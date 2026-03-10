package com.porado.backend.service;

import com.porado.backend.domain.Player;
import java.util.UUID;

public interface PlayerService {
    public Player getOrCreatePlayer(UUID playerId);
}
