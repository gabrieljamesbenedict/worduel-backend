package com.porado.worduel_backend.serviceImpl;

import com.porado.worduel_backend.model.GameStatus;
import com.porado.worduel_backend.repository.GameStatusRepo;
import com.porado.worduel_backend.service.GameStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameStatusServiceImpl implements GameStatusService {

    private final GameStatusRepo gameStatusRepo;

    @Override
    public Optional<GameStatus> getGameStatusById(Long id) {
        return gameStatusRepo.findById(id);
    }

    @Override
    public List<GameStatus> getAllGameStatuses() {
        return gameStatusRepo.findAll();
    }

    @Override
    public GameStatus createGameStatus(GameStatus gameStatus) {
        return gameStatusRepo.save(gameStatus);
    }

    @Override
    public GameStatus updateGameStatus(GameStatus gameStatus) {
        if (!gameStatusRepo.existsById(gameStatus.getStatusId())) {
            throw new RuntimeException("GameStatus not found with id " + gameStatus.getStatusId());
        }
        return gameStatusRepo.save(gameStatus);
    }

    @Override
    public void deleteGameStatusById(Long id) {
        gameStatusRepo.deleteById(id);
    }
}
