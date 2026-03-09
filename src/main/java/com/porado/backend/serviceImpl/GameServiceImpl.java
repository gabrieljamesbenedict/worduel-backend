package com.porado.backend.serviceImpl;

import com.porado.backend.model.User;
import com.porado.backend.service.GameService;
import com.porado.backend.service.UserService;
import com.porado.core.game.GameRoom;
import com.porado.core.manager.GameRoomManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRoomManager gameRoomManager;
    private final UserService userService;

    @Override
    public GameRoom createRoom(User host) {
        return gameRoomManager.createRoom(host);
    }

    @Override
    public List<GameRoom> searchRooms() {
        return gameRoomManager.getGameRoomSet().stream().toList();
    }

    @Override
    public GameRoom getRoom(Long roomId) {
        return gameRoomManager.getRoom(roomId);
    }

    @Override
    public void joinRoom(Long roomId, Long playerId) {
        User user = userService.getUserById(playerId);
        gameRoomManager.getRoom(roomId).joinPlayer(user);
    }

    @Override
    public void leaveRoom(Long roomId, Long playerId) {

    }

    @Override
    public void startGame(Long roomId) {

    }
}
