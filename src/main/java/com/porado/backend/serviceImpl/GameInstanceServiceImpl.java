package com.porado.backend.serviceImpl;

import com.porado.backend.model.GameInstance;
import com.porado.backend.repository.GameInstanceRepo;
import com.porado.backend.service.GameInstanceService;
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
    public GameInstance updateGameInstance(Long id, GameInstance gameInstance) {
        if (!gameInstanceRepo.existsById(id)) {
            throw new RuntimeException("GameInstance not found with id " + id);
        }
        return gameInstanceRepo.save(gameInstance);
    }

    @Override
    public void deleteGameInstanceById(Long id) {
        if (!gameInstanceRepo.existsById(id)) {
            throw new RuntimeException("GameInstance not found with id " + id);
        }
        gameInstanceRepo.deleteById(id);
    }
}
