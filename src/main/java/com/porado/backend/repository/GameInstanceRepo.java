package com.porado.backend.repository;

import com.porado.backend.model.GameInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameInstanceRepo extends JpaRepository<GameInstance, Long> {
}
