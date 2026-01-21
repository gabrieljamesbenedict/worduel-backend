package com.porado.worduel_backend.serviceImpl;

import com.porado.worduel_backend.model.GameInstance;
import com.porado.worduel_backend.repository.GameInstanceRepo;
import com.porado.worduel_backend.service.GameInstanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameInstanceServiceImpl implements GameInstanceService {

    private final GameInstanceRepo gameInstanceRepo;

    @Override
    public Optional<GameInstance> getGameInstanceById(Long id) {
        return gameInstanceRepo.findById(id);
    }

    @Override
    public List<GameInstance> getAllGameInstances() {
        return gameInstanceRepo.findAll();
    }

    @Override
    public GameInstance createGameInstance(GameInstance gameInstance) {
        return gameInstanceRepo.save(gameInstance);
    }

    @Override
    public GameInstance updateGameInstance(GameInstance gameInstance) {
        if (!gameInstanceRepo.existsById(gameInstance.getGameId())) {
            throw new RuntimeException("GameInstance not found with id " + gameInstance.getGameId());
        }
        return gameInstanceRepo.save(gameInstance);
    }

    @Override
    public void deleteGameInstanceById(Long id) {
        gameInstanceRepo.deleteById(id);
    }
}
