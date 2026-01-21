package com.porado.worduel_backend.repository;

import com.porado.worduel_backend.model.GameRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRoomRepo extends JpaRepository<GameRoom, Long> {
}
