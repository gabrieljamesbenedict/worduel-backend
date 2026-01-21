package com.porado.worduel_backend.service;

import com.porado.worduel_backend.model.GameInstance;

import java.util.List;
import java.util.Optional;

public interface GameInstanceService {

    Optional<GameInstance> getGameInstanceById(Long id);
    List<GameInstance> getAllGameInstances();
    GameInstance createGameInstance(GameInstance gameInstance);
    GameInstance updateGameInstance(GameInstance gameInstance);
    void deleteGameInstanceById(Long id);
}
