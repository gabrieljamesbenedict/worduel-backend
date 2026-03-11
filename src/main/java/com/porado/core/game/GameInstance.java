package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessResponse;
import com.porado.core.util.GameInstanceType;
import lombok.Data;

import java.util.UUID;

@Data
public abstract class GameInstance {

    private final GameInstanceType type;
    private final UUID gameId;
    protected final String targetWord;

    protected int maximumAttempts = 6;
    protected boolean gameOver = false;

    public GameInstance(GameInstanceType type, String targetWord) {
        this.type = type;
        this.targetWord = targetWord;
        gameId = UUID.randomUUID();
    }

    public abstract GuessResponse submitGuess(Player player, String guess);
}
