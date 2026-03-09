package com.porado.backend.serviceImpl;

import com.porado.backend.model.User;
import com.porado.backend.service.GameService;
import com.porado.core.game.GameRoom;
import com.porado.core.manager.GameRoomManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRoomManager gameRoomManager;

    @Override
    public GameRoom createRoom(User host) {
        return gameRoomManager.createRoom(host);
    }

    @Override
    public List<GameRoom> searchRooms() {
        return gameRoomManager.getGameRoomSet().stream().toList();
    }

    @Override
    public GameRoom getRoom(String roomId) {
        return gameRoomManager.getRoom(roomId);
    }

    @Override
    public void joinRoom(String roomId, String playerId) {
        gameRoomManager.
    }

    @Override
    public void leaveRoom(String roomId, String playerId) {

    }

    @Override
    public void startGame(String roomId) {

    }
}
