package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.core.util.GameRoomStatus;

import java.util.UUID;

public class DuelGameRoom extends GameRoom{

    public DuelGameRoom(UUID roomId) {
        super(roomId);
    }

    private Player player1;
    private Player player2;
    private GameRoomStatus status;

    @Override
    public void join(Player player) {
        if (player1 == null) {
            player1 = player;
            player.setCurrentRoom(this);
        } else if (player2 == null) {
            player2 = player;
            player.setCurrentRoom(this);
        };
    }

    @Override
    public void leave() {
        player1.setCurrentRoom(null);
        player1 = null;
        player2.setCurrentRoom(null);
        player2 = null;
    }

    @Override
    public void start() {
        //gameManager = new adasdasddsa
    }
}
