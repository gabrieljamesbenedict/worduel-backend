package com.porado.core.game;


import com.porado.backend.domain.Player;
import com.porado.backend.service.WordService;
import com.porado.core.util.GameInstanceType;
import com.porado.core.util.GameRoomStatus;
import com.porado.kafka.GameCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SoloGameRoom extends GameRoom {

    private GameRoomStatus status;
    private final WordService wordleService;
    private final KafkaTemplate<String, GameCompletedEvent> kafkaTemplate;

    public SoloGameRoom(UUID roomId, WordService wordleService, KafkaTemplate<String, GameCompletedEvent> kafkaTemplate) {
        super(roomId);
        this.wordleService = wordleService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void join(Player player) {
        if (!players.isEmpty()) throw new IllegalArgumentException("Cannot add more players in Solo mode");
        player.setCurrentRoomId(this.roomId);
        players.add(player);
    }

    @Override
    public void leave(Player player) {
        if (players.isEmpty()) throw new IllegalArgumentException("Cannot remove from empty list");
        player.setCurrentRoomId(null);
        players.remove(player);
    }

    @Override
    public void start() {
        String targetWord = wordleService.getRandomWord(5);
        game = new SoloGameInstance(this, GameInstanceType.SOLO, targetWord, players);
    }

    @Override
    public <T extends GameInstance> void end(T gameInstance) {

        SoloGameInstance soloGameInstance = (SoloGameInstance) gameInstance;
        String guesses = String.join(", ", soloGameInstance.getPlayerGameStats().getGuessList());

        GameCompletedEvent event = new GameCompletedEvent(
                null,
                roomId.toString(),
                GameInstanceType.SOLO,
                players.getFirst().getNickname(),
                null,
                guesses,
                null,
                LocalDateTime.now()
        );

        kafkaTemplate.send(
                "game-completed-event",
                roomId.toString(),
                event
        );

        game = null;
    }
}
