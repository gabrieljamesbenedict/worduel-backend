package com.porado.worduel_backend.service;

import com.porado.worduel_backend.model.GameStatus;

import java.util.List;

public interface GameStatusService {

    GameStatus getGameStatusById(Long id);
    List<GameStatus> getAllGameStatus();
    GameStatus createGameStatus(GameStatus gameStatus);
    GameStatus updateGameStatus(Long id, GameStatus gameStatus);
    void deleteGameStatusById(Long id);
}
