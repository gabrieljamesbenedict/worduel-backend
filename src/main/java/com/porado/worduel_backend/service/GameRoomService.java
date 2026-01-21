package com.porado.worduel_backend.service;

import com.porado.worduel_backend.model.GameRoom;

import java.util.List;
import java.util.Optional;

public interface GameRoomService {

    Optional<GameRoom> getGameRoomById(Long id);
    List<GameRoom> getAllGameRooms();
    GameRoom createGameRoom(GameRoom gameRoom);
    GameRoom updateGameRoom(GameRoom gameRoom);
    void deleteGameRoomById(Long id);
}
