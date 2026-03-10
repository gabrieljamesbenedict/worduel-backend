package com.porado.backend.controller;

import com.porado.backend.model.User;
import com.porado.backend.service.GameService;
import com.porado.backend.service.UserService;
import com.porado.core.game.GameRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;
    private final UserService userService;

    @PostMapping("/create/{hostId}")
    public GameRoom createRoom(@PathVariable Long hostId) {
        User host = userService.getUserById(hostId);
        return gameService.createRoom(host);
    }

    @GetMapping("/rooms")
    public List<GameRoom> searchRooms() {
        return gameService.searchRooms();
    }

    @GetMapping("/rooms/{roomId}")
    public GameRoom getRoom(@PathVariable Long roomId) {
        return gameService.getRoom(roomId);
    }

    @PostMapping("/rooms/{roomId}/join/{playerId}")
    public void joinRoom(
            @PathVariable Long roomId,
            @PathVariable Long playerId
    ) {
        gameService.joinRoom(roomId, playerId);
    }

    @PostMapping("/rooms/{roomId}/leave/{playerId}")
    public void leaveRoom(
            @PathVariable Long roomId,
            @PathVariable Long playerId
    ) {
        gameService.leaveRoom(roomId, playerId);
    }

    @PostMapping("/rooms/{roomId}/start")
    public void startGame(@PathVariable Long roomId) {
        gameService.startGame(roomId);
    }
}