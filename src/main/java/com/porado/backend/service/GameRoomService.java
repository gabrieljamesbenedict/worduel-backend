package com.porado.backend.service;

import com.porado.backend.model.GameRoom;

import java.util.List;
import java.util.Optional;

public interface GameRoomService {

    Optional<GameRoom> getGameRoomById(Long id);
    List<GameRoom> getAllGameRooms();
    GameRoom createGameRoom(GameRoom gameRoom);
    GameRoom updateGameRoom(Long id, GameRoom gameRoom);
    void deleteGameRoomById(Long id);
}
