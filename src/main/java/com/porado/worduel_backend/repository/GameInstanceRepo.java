package com.porado.worduel_backend.repository;

import com.porado.worduel_backend.model.GameInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameInstanceRepo extends JpaRepository<GameInstance, Long> {
}
