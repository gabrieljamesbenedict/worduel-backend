package com.porado.core.game;

import com.porado.backend.model.User;
import com.porado.core.util.GameRoomStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class GameRoom {

    private String roomId;

    private User hostPlayer;
    private List<User> playerList = new ArrayList<>();

    private int maxAmountPlayers = 6;
    private int currentAmountPlayers = 0;

    private GameRoomStatus status;

    public GameRoom(User host) {
        hostPlayer = host;
    }

    public void joinPlayer(User user) {

        if (playerList.size() >= maxAmountPlayers) {
            throw new IllegalStateException("Room is full");
        }

        currentAmountPlayers++;

        if (playerList.contains(user)) {
            return;
        }

        playerList.add(user);
    }

    public void leavePlayer(User user) {
        currentAmountPlayers--;
        playerList.remove(user);
    }

    public int getCurrentAmountPlayers() {
        return playerList.size();
    }
}
