package com.porado.backend.service;

import com.porado.backend.model.User;
import com.porado.core.game.GameRoom;

import java.util.List;

public interface GameService {
    GameRoom createRoom(User host);
    List<GameRoom> searchRooms();
    GameRoom getRoom(String roomId);
    void joinRoom(String roomId, String playerId);
    void leaveRoom(String roomId, String playerId);
    void startGame(String roomId);
}
