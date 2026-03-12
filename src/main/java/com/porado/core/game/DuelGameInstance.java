package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessResponse;
import com.porado.core.util.GameInstanceType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DuelGameInstance extends GameInstance {

    private final Map<UUID, PlayerGameStats> playerGameStatsMap = new HashMap<UUID, PlayerGameStats>();

    public DuelGameInstance(GameRoom gameRoom, GameInstanceType type, String targetWord, List<Player> playerList) {
        super(gameRoom, type, targetWord, playerList);
        for (Player p : playerList) {
            playerGameStatsMap.put(p.getPlayerId(),  new PlayerGameStats());
        }
    }

    @Override
    public GuessResponse submitGuess(Player player, String guess) {
        PlayerGameStats stats = playerGameStatsMap.get(player.getPlayerId());
        stats.setCurrentGuessAttempt(
                stats.getCurrentGuessAttempt() + 1
        );
        stats.getGuessList().add(guess);

        GuessResponse guessResponse = WordEvaluator.evaluate(targetWord, guess);
        guessResponse.setPlayerId(player.getPlayerId());

        boolean isWin = guess.equalsIgnoreCase(targetWord);

        if (isWin) {
            stats.setHasWon(true);
            stats.setHasFinished(true);
            return guessResponse;
        }

        if (stats.getCurrentGuessAttempt() >= 6) {
            stats.setHasFinished(true);
            gameRoom.end(this);
        }

        return guessResponse;
    }
}
