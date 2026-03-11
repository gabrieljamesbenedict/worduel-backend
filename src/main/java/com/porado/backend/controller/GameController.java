package com.porado.backend.controller;

import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessRequest;
import com.porado.backend.model.GuessResponse;
import com.porado.backend.model.MessageResponse;
import com.porado.backend.service.GameService;
import com.porado.backend.service.PlayerService;
import com.porado.core.game.GameRoom;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;
    private final PlayerService playerService;

    @GetMapping("/room")
    public ResponseEntity<List<GameRoom>> viewAllRooms() {
        return ResponseEntity.ok(gameService.viewAllRooms());
    }

    @PostMapping("/room")
    public ResponseEntity<GameRoom> createRoom(@RequestParam("type") String type) {
        if ("solo".equalsIgnoreCase(type)) {
            return ResponseEntity.ok(gameService.createSoloRoom());
        } else if ("duel".equalsIgnoreCase(type)) {
            return ResponseEntity.ok(gameService.createDuelRoom());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/room/{id}")
    public ResponseEntity<MessageResponse> deleteRoom(@PathVariable UUID roomId) {
        try {
            gameService.destroyRoom(roomId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/room/join")
    public ResponseEntity<GameRoom> joinRoom(HttpServletRequest request, @RequestParam("roomId") UUID roomId) {
        String id = (String) request.getAttribute("playerId");
        UUID playerId = UUID.fromString(id);
        Player player = playerService.getOrCreatePlayer(playerId);

        return ResponseEntity.ok(gameService.joinRoom(player, roomId));
    }

    @PostMapping("/room/leave")
    public ResponseEntity<GameRoom> leaveRoom(HttpServletRequest request, @RequestParam("roomId") UUID roomId) {
        String id = (String) request.getAttribute("playerId");
        UUID playerId = UUID.fromString(id);
        Player player = playerService.getOrCreatePlayer(playerId);

        return ResponseEntity.ok(gameService.leaveRoom(player, roomId));
    }

    @PostMapping("/room/start")
    public ResponseEntity<GameRoom> startRoom(@RequestParam("roomId") UUID roomId) {
        return ResponseEntity.ok(gameService.startRoom(roomId));
    }

    @PostMapping("/room/guess")
    public ResponseEntity<GuessResponse> submitGuess(HttpServletRequest request, @RequestBody GuessRequest guessRequest) {
        String id = (String) request.getAttribute("playerId");
        UUID playerId = UUID.fromString(id);
        Player player = playerService.getOrCreatePlayer(playerId);
        guessRequest.setPlayer(player);
        return ResponseEntity.ok(gameService.submitGuess(guessRequest));
    }
}