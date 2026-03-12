package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessResponse;
import com.porado.core.util.GameInstanceType;
import com.porado.core.util.LetterType;

import java.util.*;

public class SoloGameInstance extends GameInstance{

    private final PlayerGameStats playerGameStats = new PlayerGameStats();

    public SoloGameInstance(GameRoom gameRoom, GameInstanceType type, String targetWord, List<Player> playerList) {
        super(gameRoom, type, targetWord, playerList);
    }

    @Override
    public GuessResponse submitGuess(Player player, String guess) {
        playerGameStats.setCurrentGuessAttempt(
                playerGameStats.getCurrentGuessAttempt() + 1
        );
        playerGameStats.getGuessList().add(guess);

        GuessResponse guessResponse = WordEvaluator.evaluate(targetWord, guess);
        guessResponse.setPlayerId(player.getPlayerId());

        boolean isWin = guess.equalsIgnoreCase(targetWord);

        if (isWin) {
            playerGameStats.setHasWon(true);
            playerGameStats.setHasFinished(true);
            return guessResponse;
        }

        if (playerGameStats.getCurrentGuessAttempt() >= 6) {
            playerGameStats.setHasFinished(true);
            gameRoom.end();
        }

        return guessResponse;
    }
}
