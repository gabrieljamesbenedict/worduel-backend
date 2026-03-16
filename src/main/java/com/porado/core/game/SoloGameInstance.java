package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessResponse;
import com.porado.core.util.GameInstanceType;
import com.porado.core.util.LetterType;
import lombok.Getter;

import java.util.*;

public class SoloGameInstance extends GameInstance{

    private final UUID playerId;

    public SoloGameInstance(GameRoom gameRoom, GameInstanceType type, String targetWord, List<Player> playerList) {
        super(gameRoom, type, targetWord, playerList);
        playerId = playerList.getFirst().getPlayerId();
        playerGameStats.put(playerId, new PlayerGameStats());
    }

    @Override
    public GuessResponse submitGuess(Player player, String guess) {
        playerGameStats.get(playerId).setCurrentGuessAttempt(
                playerGameStats.get(playerId).getCurrentGuessAttempt() + 1
        );
        playerGameStats.get(playerId).getGuessList().add(guess);

        GuessResponse guessResponse = WordEvaluator.evaluate(targetWord, guess);
        guessResponse.setPlayerId(player.getPlayerId());

        boolean isWin = guess.equalsIgnoreCase(targetWord);

        if (isWin) {
            playerGameStats.get(playerId).setHasWon(true);
            playerGameStats.get(playerId).setHasFinished(true);
            gameRoom.end(this);
            return guessResponse;
        }

        if (playerGameStats.get(playerId).getCurrentGuessAttempt() >= 6) {
            playerGameStats.get(playerId).setHasFinished(true);
            gameRoom.end(this);
        }

        return guessResponse;
    }
}
