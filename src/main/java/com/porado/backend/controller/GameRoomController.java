package com.porado.backend.controller;

import com.porado.backend.model.GameRoom;
import com.porado.backend.service.GameRoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class GameRoomController {

    private final GameRoomService gameRoomService;

    @GetMapping("/{id}")
    public ResponseEntity<GameRoom> getGameRoomById(@PathVariable Long id) {
        Optional<GameRoom> gameRoomOptional = gameRoomService.getGameRoomById(id);

        return gameRoomOptional
                .map(
                        ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()
                );
    }

    @GetMapping
    public ResponseEntity<List<GameRoom>> getAllGameRooms() {
        return ResponseEntity.ok(gameRoomService.getAllGameRooms());
    }

    @PostMapping
    public ResponseEntity<GameRoom> createGameRoom(@Valid @RequestBody GameRoom gameRoom) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameRoomService.createGameRoom(gameRoom));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameRoom> updateGameRoom(@PathVariable Long id, @Valid @RequestBody GameRoom gameRoom) {
        return ResponseEntity.ok(gameRoomService.updateGameRoom(id, gameRoom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GameRoom> deleteGameRoom(@PathVariable Long id) {
        gameRoomService.deleteGameRoomById(id);
        return ResponseEntity.noContent().build();
    }


}
