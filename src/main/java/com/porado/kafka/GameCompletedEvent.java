package com.porado.kafka;

import com.porado.core.util.GameInstanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCompletedEvent {

    private Long id;
    private String roomId;
    private GameInstanceType type;

    private String player1;
    private String player2;

    private String guesses1;
    private String guesses2;

    private LocalDateTime completedAt;
}