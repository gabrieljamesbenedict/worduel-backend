package com.porado.kafka;

import com.porado.kafka.GameCompletedEvent;
import com.porado.backend.service.GameStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameCompletedEventListener {

    private final GameStatisticsService gameStatisticsService;

    @KafkaListener(topics = "game-completed-event", containerFactory = "kafkaListenerContainerFactory")
    public void handleGameCompleted(GameCompletedEvent event) {
        try {
            gameStatisticsService.saveToDatabase(event);
            System.out.println("Saved to database: " + event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}