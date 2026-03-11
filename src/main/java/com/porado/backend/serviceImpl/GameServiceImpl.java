package com.porado.backend.serviceImpl;

import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessRequest;
import com.porado.backend.model.GuessResponse;
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

    @Override
    public GameRoom joinRoom(Player player, UUID gameRoom) {
        gameRoomManager
                .findGameRoomById(gameRoom)
                .join(player);
        return gameRoomManager.findGameRoomById(gameRoom);
    }

    @Override
    public GameRoom leaveRoom(Player player, UUID gameRoom) {
        gameRoomManager
                .findGameRoomById(gameRoom)
                .leave(player);
        return gameRoomManager.findGameRoomById(gameRoom);
    }

    @Override
    public GameRoom startRoom(UUID gameRoom) {
        gameRoomManager
                .findGameRoomById(gameRoom)
                .start();
        return gameRoomManager.findGameRoomById(gameRoom);
    }

    @Override
    public GuessResponse submitGuess(GuessRequest guessRequest) {
        return gameRoomManager
                .findGameRoomById(guessRequest.getRoomId())
                .getGame()
                .submitGuess(guessRequest.getPlayer(), guessRequest.getGuess());
    }

}
