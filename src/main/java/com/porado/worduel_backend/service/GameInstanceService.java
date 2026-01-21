package com.porado.worduel_backend.service;

import com.porado.worduel_backend.model.GameInstance;

import java.util.List;

public interface GameInstanceService {

    GameInstance getGameInstanceById(Long id);
    List<GameInstance> getAllGameInstance();
    GameInstance createGameInstance(GameInstance gameInstance);
    GameInstance updateGameInstance(Long id, GameInstance gameInstance);
    void deleteGameInstanceById(Long id);
}
