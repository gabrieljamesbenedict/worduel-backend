package com.porado.core.game;

import com.porado.backend.model.GuessResponse;
import com.porado.core.util.LetterType;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class WordEvaluator {

    public static GuessResponse evaluate(String target, String guess) {

        String targetStr = target.toUpperCase();
        String guessStr = guess.toUpperCase();

        char[] targetChars = targetStr.toCharArray();
        char[] guessChars = guessStr.toCharArray();

        int length = targetChars.length;

        LetterType[] result = new LetterType[length];

        Map<Character, Integer> letterCount = new HashMap<>();

        for (char c : targetChars) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < length; i++) {
            if (guessChars[i] == targetChars[i]) {
                result[i] = LetterType.CORRECT;

                char c = guessChars[i];
                letterCount.put(c, letterCount.get(c) - 1);
            }
        }

        for (int i = 0; i < length; i++) {

            if (result[i] != null) {
                continue;
            }

            char g = guessChars[i];

            if (letterCount.getOrDefault(g, 0) > 0) {
                result[i] = LetterType.PRESENT;
                letterCount.put(g, letterCount.get(g) - 1);
            } else {
                result[i] = LetterType.ABSENT;
            }
        }

        return new GuessResponse(
                guessStr,
                targetStr,
                Arrays.asList(result)
        );
    }
}
