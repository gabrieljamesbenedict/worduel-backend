package com.porado.backend.serviceImpl;

import com.porado.backend.domain.Player;
import com.porado.backend.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PlayeServiceImpl implements PlayerService {

    private final Map<UUID, Player> players = new ConcurrentHashMap<>();

    @Override
    public Player getOrCreatePlayer(UUID playerId) {
        return players.computeIfAbsent(playerId, Player::new);
    }
}
