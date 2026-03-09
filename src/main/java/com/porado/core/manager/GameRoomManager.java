package com.porado.core.manager;


import com.porado.backend.model.User;
import com.porado.core.game.GameRoom;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class GameRoomManager {

    @Getter
    private final Set<GameRoom> gameRoomSet = new HashSet<>();

    public GameRoom createRoom(User host) {
        GameRoom room = new GameRoom(host);
        gameRoomSet.add(room);
        return room;
    }

    public GameRoom getRoom(Long roomId) {
        Optional<GameRoom> room = gameRoomSet.stream()
                .filter(r -> r.getRoomId().equals(roomId))
                .findFirst();

        return room.orElse(null);
    }

    public Set<GameRoom> getAllRooms() {
        return gameRoomSet;
    }

    public void removeRoom(Long roomId) {
        gameRoomSet.removeIf(room -> room.getRoomId().equals(roomId));
    }

    public boolean roomExists(Long roomId) {
        gameRoomSet.stream()
                .anyMatch(room -> room.getRoomId().equals(roomId));
        return false;
    }

}
