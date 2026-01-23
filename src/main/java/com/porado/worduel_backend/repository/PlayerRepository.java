package com.porado.worduel_backend.repository;

import com.porado.worduel_backend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository  extends JpaRepository<Player, Long> {
}
