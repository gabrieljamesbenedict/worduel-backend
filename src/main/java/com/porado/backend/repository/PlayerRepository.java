package com.porado.backend.repository;

import com.porado.backend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository  extends JpaRepository<Player, Long> {
    Boolean existsByUsername(String username);
}
