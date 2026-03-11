package com.porado.core.game;


import com.porado.backend.domain.Player;
import com.porado.core.util.GameInstanceType;
import com.porado.core.util.GameRoomStatus;

import java.util.UUID;

public class SoloGameRoom extends GameRoom {

    private Player player;
    private GameRoomStatus status;
    private final String targetWord;

    public SoloGameRoom(UUID roomId, String targetWord) {
        super(roomId);
        this.targetWord = targetWord;
    }

    @Override
    public void join(Player player) {
        this.player = player;
        players.add(player);
        player.setCurrentRoomId(this.roomId);
    }

    @Override
    public void leave(Player player) {
        if (this.player.getPlayerId() == player.getPlayerId()) {
            player.setCurrentRoomId(null);
            players.remove(player);
            this.player = null;
        }
    }

    @Override
    public void start() {
        if (targetWord == null || targetWord.isEmpty()) throw new IllegalStateException("Target word must not be blank");
        game = new SoloGameInstance(GameInstanceType.SOLO, targetWord);
    }
}
