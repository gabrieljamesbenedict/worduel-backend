package com.porado.core.game;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessResponse;
import com.porado.core.util.GameInstanceType;
import lombok.Data;

import java.util.*;

@Data
public abstract class GameInstance {

    @JsonIgnore
    protected transient final GameRoom gameRoom;

    private final GameInstanceType type;
    private final UUID gameId;
    protected final String targetWord;
    protected Map<UUID, PlayerGameStats> playerGameStats = new HashMap<>();

    @JsonIgnore
    protected final List<Player> playerList;

    protected int maximumAttempts = 6;
    protected boolean gameOver = false;

    public GameInstance(GameRoom gameRoom, GameInstanceType type, String targetWord, List<Player> playerList) {
        this.gameRoom = gameRoom;
        this.type = type;
        this.targetWord = targetWord;
        this.playerList = playerList;

        gameId = UUID.randomUUID();
    }

    public abstract GuessResponse submitGuess(Player player, String guess);
}
