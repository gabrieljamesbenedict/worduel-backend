package com.porado.backend.model;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "statusId", nullable = false)
    private GameStatus gameStatus;

    @OneToOne
    @JoinColumn(name = "roomId", nullable = false)
    private GameRoom gameRoom;

}
