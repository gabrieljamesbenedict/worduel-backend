package com.porado.backend.repository;

import com.porado.backend.entity.GameStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameStatisticsRepository extends JpaRepository<GameStatistics, Long> {
}
