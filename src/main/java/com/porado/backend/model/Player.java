package com.porado.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Players")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Builder.Default
    private boolean enabled = true;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private PlayerRole role;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "roomId", nullable = true)
    private GameRoom gameRoom;

}
