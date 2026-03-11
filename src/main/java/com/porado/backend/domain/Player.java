package com.porado.backend.domain;

import com.porado.core.game.GameRoom;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Player {

    private final UUID playerId;
    private String nickname;
    private UUID currentRoomId;

}
