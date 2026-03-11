package com.porado.core.game;

import com.porado.backend.domain.Player;
import com.porado.backend.service.WordService;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public abstract class GameRoom {

    protected final UUID roomId;
    protected GameInstance game;

    public abstract void join(Player player);
    public abstract void leave();
    public abstract void start();

}
