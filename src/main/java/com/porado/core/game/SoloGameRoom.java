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
        player.setCurrentRoom(this);
    }

    @Override
    public void leave() {
        player.setCurrentRoom(null);
        player = null;
    }

    @Override
    public void start() {
        game = new SoloGameInstance(GameInstanceType.SOLO, targetWord);
    }
}
