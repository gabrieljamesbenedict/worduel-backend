package com.porado.core.game;


import com.porado.backend.domain.Player;
import com.porado.core.util.GameInstanceType;
import com.porado.core.util.GameRoomStatus;

import java.util.UUID;

public class SoloGameRoom extends GameRoom {

    private GameRoomStatus status;
    private final String targetWord;

    public SoloGameRoom(UUID roomId, String targetWord) {
        super(roomId);
        this.targetWord = targetWord;
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
        if (targetWord == null || targetWord.isEmpty()) throw new IllegalStateException("Target word must not be blank");
        game = new SoloGameInstance(GameInstanceType.SOLO, targetWord, players);
    }

    @Override
    public void end() {
        game = null;
    }
}
