package com.porado.core.manager;

import com.porado.backend.service.WordService;
import com.porado.core.game.DuelGameRoom;
import com.porado.core.game.GameRoom;
import com.porado.core.game.SoloGameRoom;
import com.porado.kafka.GameCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class GameRoomManager {

    private final WordService wordService;
    private final Set<GameRoom> rooms = ConcurrentHashMap.newKeySet();
    private final KafkaTemplate<String, GameCompletedEvent> kafkaTemplate;

    public List<GameRoom> findAllGameRoom() {
        return rooms.stream().toList();
    }

    public GameRoom findGameRoomById(UUID roomId) {
        return rooms
                .stream()
                .filter(gameRoom -> gameRoom.getRoomId().equals(roomId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
    }

    public SoloGameRoom createSoloRoom() {
        UUID roomId = UUID.randomUUID();
        SoloGameRoom room = new SoloGameRoom(roomId, wordService, kafkaTemplate);
        rooms.add(room);
        return room;
    }

    public DuelGameRoom createDuelRoom() {
        UUID roomId = UUID.randomUUID();
        DuelGameRoom room = new DuelGameRoom(roomId, wordService, kafkaTemplate);
        rooms.add(room);
        return room;
    }

    public boolean destroyRoom(GameRoom room) {
        return rooms.remove(room);
    }

}