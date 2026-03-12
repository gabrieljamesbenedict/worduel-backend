package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.service.WordService;
import com.porado.core.util.GameInstanceType;
import com.porado.core.util.GameRoomStatus;
import com.porado.kafka.GameCompletedEvent;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

public class DuelGameRoom extends GameRoom{

    private GameRoomStatus status;
    private final WordService wordleService;
    private final KafkaTemplate<String, GameCompletedEvent> kafkaTemplate;

    public DuelGameRoom(UUID roomId, WordService wordleService, KafkaTemplate<String, GameCompletedEvent> kafkaTemplate) {
        super(roomId);
        this.wordleService = wordleService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void join(Player player) {
        if (players.size() >= 2) throw new IllegalArgumentException("Cannot add more than 2 players in Duel mode");
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
        game = new DuelGameInstance(this, GameInstanceType.DUEL, targetWord, players);
    }

    @Override
    public <T extends GameInstance> void end(T gameInstance) {
        DuelGameInstance duelGameInstance = (DuelGameInstance) gameInstance;
        game = null;
    }

}
