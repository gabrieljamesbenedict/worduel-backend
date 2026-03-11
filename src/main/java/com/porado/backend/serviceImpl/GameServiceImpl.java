package com.porado.backend.serviceImpl;

import com.porado.backend.service.GameService;
import com.porado.core.game.GameRoom;
import com.porado.core.manager.GameRoomManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRoomManager gameRoomManager;

    @Override
    public List<GameRoom> viewAllRooms() {
        return gameRoomManager.findAllGameRoom();
    }

    @Override
    public GameRoom createSoloRoom() {
        return gameRoomManager.createSoloRoom();
    }

    @Override
    public GameRoom createDuelRoom() {
        //return gameRoomManager.createDuelRoom();
        return null;
    }
    @Override
    public void destroyRoom(UUID roomId) {
        gameRoomManager.destroyRoom(gameRoomManager.findGameRoomById(roomId)     );
    }

}
