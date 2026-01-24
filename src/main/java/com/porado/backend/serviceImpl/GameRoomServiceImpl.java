package com.porado.backend.serviceImpl;

import com.porado.backend.model.GameRoom;
import com.porado.backend.repository.GameRoomRepo;
import com.porado.backend.service.GameRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameRoomServiceImpl implements GameRoomService {

    private final GameRoomRepo gameRoomRepo;

    @Override
    public Optional<GameRoom> getGameRoomById(Long id) {
        return gameRoomRepo.findById(id);
    }

    @Override
    public List<GameRoom> getAllGameRooms() {
        return gameRoomRepo.findAll();
    }

    @Override
    public GameRoom createGameRoom(GameRoom gameRoom) {
        return gameRoomRepo.save(gameRoom);
    }

    @Override
    public GameRoom updateGameRoom(Long id, GameRoom gameRoom) {
        if (!gameRoomRepo.existsById(id)) {
            throw new RuntimeException("GameRoom not found with id " + id);
        }
        return gameRoomRepo.save(gameRoom);
    }

    @Override
    public void deleteGameRoomById(Long id) {
        if (!gameRoomRepo.existsById(id)) {
            throw new RuntimeException("GameRoom not found with id " + id);
        }
        gameRoomRepo.deleteById(id);
    }
}
