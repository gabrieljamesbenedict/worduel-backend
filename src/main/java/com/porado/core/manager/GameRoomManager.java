package com.porado.core.manager;

import com.porado.backend.service.WordService;
import com.porado.core.game.DuelGameRoom;
import com.porado.core.game.GameRoom;
import com.porado.core.game.SoloGameRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class GameRoomManager {

    private final WordService wordService;
    private final Set<GameRoom> rooms = ConcurrentHashMap.newKeySet();

    public SoloGameRoom createSoloRoom() {
        UUID roomId = UUID.randomUUID();
        String targetWord = wordService.getRandomWord(5).getWord();
        SoloGameRoom room = new SoloGameRoom(roomId, targetWord);
        rooms.add(room);
        return room;
    }

    public DuelGameRoom createDuelRoom() {
        UUID roomId = UUID.randomUUID();
        DuelGameRoom room = new DuelGameRoom(roomId);
        rooms.add(room);
        return room;
    }

    public boolean destroyRoom(GameRoom room) {
        return rooms.remove(room);
    }

}