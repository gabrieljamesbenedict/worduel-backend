package com.porado.backend.service;

import com.porado.backend.model.User;
import com.porado.core.game.GameRoom;

import java.util.List;

public interface GameService {
    GameRoom createRoom(User host);
    List<GameRoom> searchRooms();
    GameRoom getRoom(Long roomId);
    void joinRoom(Long roomId, Long playerId);
    void leaveRoom(Long roomId, Long playerId);
    void startGame(Long roomId);
}
