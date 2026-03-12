package com.porado.core.game;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlayerGameStats {
    private int currentGuessAttempt = 0;
    private List<String> guessList = new ArrayList<>();
    private boolean hasWon = false;
}
