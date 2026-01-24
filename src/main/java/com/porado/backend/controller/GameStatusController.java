//package com.porado.worduel_backend.controller;
//
//import com.porado.worduel_backend.model.GameStatus;
//import com.porado.worduel_backend.service.GameStatusService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/statuses")
//@RequiredArgsConstructor
//public class GameStatusController {
//
//    private final GameStatusService gameStatusService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<GameStatus> getGameStatusById(@PathVariable Long id) {
//        Optional<GameStatus> gameStatusOptional = gameStatusService.getGameStatusById(id);
//
//        return gameStatusOptional
//                .map(
//                        ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()
//                );
//    }
//
//    @GetMapping
//    public ResponseEntity<List<GameStatus>> getAllGameStatuses() {
//        return ResponseEntity.ok(gameStatusService.getAllGameStatuses());
//    }
//
//    @PostMapping
//    public ResponseEntity<GameStatus> createGameStatus(@Valid @RequestBody GameStatus gameRoom) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(gameStatusService.createGameStatus(gameRoom));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<GameStatus> updateGameStatus(@PathVariable Long id, @Valid @RequestBody GameStatus gameRoom) {
//        return ResponseEntity.ok(gameStatusService.updateGameStatus(id, gameRoom));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<GameStatus> deleteGameStatus(@PathVariable Long id) {
//        gameStatusService.deleteGameStatusById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//}
