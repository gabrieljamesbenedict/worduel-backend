package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.model.GuessResponse;
import com.porado.core.util.GameInstanceType;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DuelGameInstance extends GameInstance {

    public DuelGameInstance(GameRoom gameRoom, GameInstanceType type, String targetWord, List<Player> playerList) {
        super(gameRoom, type, targetWord, playerList);
        for (Player p : playerList) {
            playerGameStats.put(p.getPlayerId(),  new PlayerGameStats());
        }
        System.out.println("INITIATED NEW GAME ROOM");
        System.out.println(playerGameStats.toString());
    }

    @Override
    public GuessResponse submitGuess(Player player, String guess) {

//        System.out.println(playerGameStats.toString());
//        System.out.println("PlayerID="+player.getPlayerId() + " Guess="+guess);
//        PlayerGameStats stat = playerGameStats.get(player.getPlayerId());
//        System.out.println("Stat="+stat.toString());

        playerGameStats.get(player.getPlayerId()).setCurrentGuessAttempt(
                playerGameStats.get(player.getPlayerId()).getCurrentGuessAttempt() + 1
        );
        playerGameStats.get(player.getPlayerId()).getGuessList().add(guess);

        GuessResponse guessResponse = WordEvaluator.evaluate(targetWord, guess);
        guessResponse.setPlayerId(player.getPlayerId());

        boolean isWin = guess.equalsIgnoreCase(targetWord);

        if (isWin) {
            playerGameStats.get(player.getPlayerId()).setHasWon(true);
            playerGameStats.get(player.getPlayerId()).setHasFinished(true);
        }

        if (playerGameStats.get(player.getPlayerId()).getCurrentGuessAttempt() >= 6) {
            playerGameStats.get(player.getPlayerId()).setHasFinished(true);
            //gameRoom.end(this); DO NOT END THE GAME IF YOU LOST IN MULTIPLAYER
        }

        return guessResponse;
    }
}
