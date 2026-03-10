package com.porado.backend.domain;

import com.porado.core.game.GameRoom;
import lombok.Data;

import java.util.UUID;

@Data
public class Player {

    private UUID playerId;
    private String nickname;
    private GameRoom currentRoom;

}
