package com.porado.worduel_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GameInstances")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private GameStatus gameStatus;

}
