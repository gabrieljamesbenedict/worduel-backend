package com.porado.backend.service;

import com.porado.backend.entity.GameStatistics;
import com.porado.kafka.GameCompletedEvent;

public interface GameStatisticsService {
    void saveToDatabase(GameCompletedEvent gameCompletedEvent);
}
