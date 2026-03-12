package com.porado.core.game;


import com.porado.backend.domain.Player;
import com.porado.backend.service.WordService;
import com.porado.core.util.GameInstanceType;
import com.porado.core.util.GameRoomStatus;

import java.util.UUID;

public class SoloGameRoom extends GameRoom {

    private GameRoomStatus status;
    private final WordService wordleService;

    public SoloGameRoom(UUID roomId, WordService wordleService) {
        super(roomId);
        this.wordleService = wordleService;
    }

    @Override
    public void join(Player player) {
        if (!players.isEmpty()) throw new IllegalArgumentException("Cannot add more players in Solo mode");
        player.setCurrentRoomId(this.roomId);
        players.add(player);
    }

    @Override
    public void leave(Player player) {
        if (players.isEmpty()) throw new IllegalArgumentException("Cannot remove from empty list");
        player.setCurrentRoomId(null);
        players.remove(player);
    }

    @Override
    public void start() {
        String targetWord = wordleService.getRandomWord(5);
        game = new SoloGameInstance(this, GameInstanceType.SOLO, targetWord, players);
    }

    @Override
    public void end() {
        game = null;
    }
}
