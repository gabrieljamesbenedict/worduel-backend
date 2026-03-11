package com.porado.backend.model;

import com.porado.backend.domain.Player;
import com.porado.core.util.LetterType;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class GuessRequest {
    private final UUID roomId;
    private final UUID playerId;
    private Player player; // null on start
    private final String guess;
}