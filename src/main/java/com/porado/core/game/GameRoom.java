package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.core.manager.GameInstanceManager;
import com.porado.core.manager.SoloGameInstanceManager;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public abstract class GameRoom {

    protected final UUID roomId;
    protected GameInstanceManager gameManager;

    public abstract void join(Player player);
    public abstract void leave();
    public abstract void start();

}
