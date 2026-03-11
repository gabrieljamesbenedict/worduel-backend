package com.porado.core.manager;

import com.porado.core.game.DuelGameRoom;
import com.porado.core.game.GameRoom;
import com.porado.core.game.SoloGameRoom;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GameRoomManager {

    private final Set<GameRoom> rooms = ConcurrentHashMap.newKeySet();

    public SoloGameRoom createSoloRoom() {
        UUID roomId = UUID.randomUUID();
        SoloGameRoom room = new SoloGameRoom(roomId);
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