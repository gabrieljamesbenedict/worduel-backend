package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessResponse;
import com.porado.core.util.GameInstanceType;
import com.porado.core.util.LetterType;

import java.util.*;

public class SoloGameInstance extends GameInstance{

    private final PlayerGameStats playerGameStats = new PlayerGameStats();

    public SoloGameInstance(GameInstanceType type, String targetWord, List<Player> playerList) {
        super(type, targetWord, playerList);
    }

    @Override
    public GuessResponse submitGuess(Player player, String guess) {
        playerGameStats.setCurrentGuessAttempt(
                playerGameStats.getCurrentGuessAttempt() + 1
        );
        playerGameStats.getGuessList().add(guess);

        String guessStr = guess.toUpperCase();
        String targetStr = targetWord.toUpperCase();

        if (Objects.equals(guessStr, targetStr)) {
            playerGameStats.setHasWon(true);
            return new GuessResponse(
                    player.getPlayerId(),
                    guessStr,
                    List.of(
                            LetterType.CORRECT,
                            LetterType.CORRECT,
                            LetterType.CORRECT,
                            LetterType.CORRECT,
                            LetterType.CORRECT)
            );
        }

        Map<Character, Integer> letterCountMap = new HashMap<>();
        for (char c : targetStr.toCharArray()) {
            letterCountMap.put(c, letterCountMap.getOrDefault(c, 0) + 1);
        }

        char[] guessCharArray = guessStr.toCharArray();
        char[] targetCharArray = targetStr.toCharArray();
        List<LetterType> result = new ArrayList<>();
        for (int i = 0; i < guessCharArray.length; i++) {
            if (targetCharArray[i] == guessCharArray[i]) {
                result.add(LetterType.CORRECT);
            } else if (letterCountMap.containsKey(guessCharArray[i])) {
                result.add(LetterType.PRESENT);
                letterCountMap.put(guessCharArray[i], letterCountMap.get(guessCharArray[i]) - 1);
            } else {
                result.add(LetterType.ABSENT);
            }
        }

        if (playerGameStats.getCurrentGuessAttempt() >= 6) {
            playerGameStats.setHasWon(false);
        }

        return new GuessResponse(player.getPlayerId(),targetWord, result);
    }
}
