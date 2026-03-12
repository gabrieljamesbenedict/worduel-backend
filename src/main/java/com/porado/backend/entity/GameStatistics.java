package com.porado.backend.entity;

import com.porado.backend.domain.Player;
import com.porado.core.util.GameInstanceType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "game_statistics")
public class GameStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String roomId;

    @Column(nullable = false)
    private GameInstanceType type;

    @Column(nullable = false)
    private String player1;

    @Column(nullable = false)
    private String player2;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String guesses1;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String guesses2;

    @Column(nullable = false)
    private LocalDateTime completedAt;

    public GameStatistics(Long id, String roomId, GameInstanceType type, String player1, String player2, String guesses1, String guesses2, LocalDateTime completedAt) {
        this.id = id;
        this.roomId = roomId;
        this.type = type;
        this.player1 = player1;
        this.player2 = player2;
        this.guesses1 = guesses1;
        this.guesses2 = guesses2;
        this.completedAt = completedAt;
    }
}
