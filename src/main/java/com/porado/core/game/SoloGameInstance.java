package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessResponse;
import com.porado.core.util.GameInstanceType;
import com.porado.core.util.LetterType;

import java.util.*;

public class SoloGameInstance extends GameInstance{

    public SoloGameInstance(GameInstanceType type, String targetWord) {
        super(type, targetWord);
    }

    private Player player;

    private int currentGuessAttempt = 0;

    @Override
    public GuessResponse submitGuess(Player player, String guess) {
        if (this.player.getPlayerId() != player.getPlayerId()) throw new IllegalArgumentException("Not the same Player");
        currentGuessAttempt++;

        String guessStr = guess.toUpperCase();
        String targetStr = targetWord.toUpperCase();

        if (Objects.equals(guessStr, targetStr)) {
            return new GuessResponse(
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

        return new GuessResponse(targetWord, result);
    }
}
