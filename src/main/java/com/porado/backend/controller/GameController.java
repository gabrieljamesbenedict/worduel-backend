package com.porado.backend.controller;

import com.porado.backend.model.MessageResponse;
import com.porado.backend.service.GameService;
import com.porado.core.game.GameRoom;
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

    @GetMapping
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

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteRoom(@PathVariable UUID roomId) {
        try {
            gameService.destroyRoom(roomId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}