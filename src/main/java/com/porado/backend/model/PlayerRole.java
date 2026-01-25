package com.porado.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PlayerRoles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerRole {

    @Id
    private Long roleId;

    @Column(nullable = false)
    private String name;
}
