package com.porado.backend.controller;

import com.porado.backend.model.GameInstance;
import com.porado.backend.service.GameInstanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameInstanceController {

    private final GameInstanceService gameInstanceService;

    @GetMapping("/{id}")
    public ResponseEntity<GameInstance> getGameInstanceById(@PathVariable Long id) {
        Optional<GameInstance> gameInstanceOptional = gameInstanceService.getGameInstanceById(id);

        return gameInstanceOptional
                .map(
                        ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()
                );
    }

    @GetMapping
    public ResponseEntity<List<GameInstance>> getAllGameInstances() {
        return ResponseEntity.ok(gameInstanceService.getAllGameInstances());
    }

    @PostMapping
    public ResponseEntity<GameInstance> createGameInstance(@Valid @RequestBody GameInstance gameInstance) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameInstanceService.createGameInstance(gameInstance));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameInstance> updateGameInstance(@PathVariable Long id, @Valid @RequestBody GameInstance gameInstance) {
        return ResponseEntity.ok(gameInstanceService.updateGameInstance(id ,gameInstance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GameInstance> deleteGameInstance(@PathVariable Long id) {
        gameInstanceService.deleteGameInstanceById(id);
        return ResponseEntity.noContent().build();
    }

}
