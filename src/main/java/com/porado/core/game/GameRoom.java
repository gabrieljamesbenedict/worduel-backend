package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.service.WordService;
import com.porado.core.util.GameInstanceType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public abstract class GameRoom {

    protected final UUID roomId;
    protected GameInstanceType roomType;
    protected GameInstance game;
    protected List<Player> players = new ArrayList<>();

    public abstract void join(Player player);
    public abstract void leave(Player player);
    public abstract void start();
    public abstract <T extends GameInstance> void end(T gameInstance);
}
