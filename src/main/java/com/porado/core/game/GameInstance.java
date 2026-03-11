package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessResult;
import com.porado.backend.service.WordService;
import com.porado.core.util.GameInstanceType;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Data
public abstract class GameInstance {

    private final GameInstanceType type;
    private final UUID gameId;
    protected final String targetWord = null;

    protected int maximumAttempts = 6;
    protected boolean gameOver = false;

    public GameInstance(GameInstanceType type) {
        this.type = type;
        gameId = UUID.randomUUID();
    }

    public abstract GuessResult submitGuess(Player player, String guess);
}
