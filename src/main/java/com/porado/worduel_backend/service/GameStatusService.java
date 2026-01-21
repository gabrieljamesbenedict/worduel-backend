package com.porado.worduel_backend.service;

import com.porado.worduel_backend.model.GameStatus;

import java.util.List;
import java.util.Optional;

public interface GameStatusService {

    Optional<GameStatus> getGameStatusById(Long id);
    List<GameStatus> getAllGameStatuses();
    GameStatus createGameStatus(GameStatus gameStatus);
    GameStatus updateGameStatus(Long id, GameStatus gameStatus);
    void deleteGameStatusById(Long id);
}
