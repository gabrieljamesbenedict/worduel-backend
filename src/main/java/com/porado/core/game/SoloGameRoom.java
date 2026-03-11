package com.porado.core.game;


import com.porado.backend.domain.Player;
import com.porado.core.manager.SoloGameInstanceManager;
import com.porado.core.util.GameRoomStatus;

import java.util.UUID;

public class SoloGameRoom extends GameRoom {

    public SoloGameRoom(UUID roomId) {
        super(roomId);
    }

    private Player player;
    private GameRoomStatus status;

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
