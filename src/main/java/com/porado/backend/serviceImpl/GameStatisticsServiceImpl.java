package com.porado.backend.serviceImpl;

import com.porado.backend.entity.GameStatistics;
import com.porado.backend.repository.GameStatisticsRepository;
import com.porado.backend.service.GameStatisticsService;
import com.porado.kafka.GameCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GameStatisticsServiceImpl implements GameStatisticsService {

    private final GameStatisticsRepository gameStatisticsRepository;

    @Override
    public void saveToDatabase(GameCompletedEvent gameCompletedEvent) {
        gameStatisticsRepository.save(GameStatistics.fromEvent(gameCompletedEvent));
    }
}
