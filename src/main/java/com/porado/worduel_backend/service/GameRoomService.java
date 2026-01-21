package com.porado.worduel_backend.service;

import com.porado.worduel_backend.model.GameRoom;

import java.util.List;

public interface GameRoomService {

    GameRoom getGameRoomById(Long id);
    List<GameRoom> getAllGameRoom();
    GameRoom createGameRoom(GameRoom gameRoom);
    GameRoom updateGameRoom(Long id, GameRoom gameRoom);
    void deleteGameRoomById(Long id);
}
