package com.porado.worduel_backend.serviceImpl;

import com.porado.worduel_backend.model.GameRoom;
import com.porado.worduel_backend.repository.GameRoomRepo;
import com.porado.worduel_backend.service.GameRoomService;
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
    public GameRoom updateGameRoom(GameRoom gameRoom) {
        if (!gameRoomRepo.existsById(gameRoom.getRoomId())) {
            throw new RuntimeException("GameRoom not found with id " + gameRoom.getRoomId());
        }
        return gameRoomRepo.save(gameRoom);
    }

    @Override
    public void deleteGameRoomById(Long id) {
        gameRoomRepo.deleteById(id);
    }
}
