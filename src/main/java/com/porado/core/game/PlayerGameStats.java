package com.porado.core.game;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class PlayerGameStats {
    private UUID playerId;
    private int currentGuessAttempt = 0;
    private List<String> guessList = new ArrayList<>();
    private boolean hasWon = false;
    private boolean hasFinished = false;
}
