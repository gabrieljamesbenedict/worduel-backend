package com.porado.backend.repository;

import com.porado.backend.model.GameRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRoomRepo extends JpaRepository<GameRoom, Long> {
}
