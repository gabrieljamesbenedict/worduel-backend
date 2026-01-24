package com.porado.backend.service;

import com.porado.backend.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    Optional<Player> getPlayerById(Long id);
    List<Player> getAllPlayers();
    Player createPlayer(Player player);
    Player updatePlayer(Long id, Player player);
    void deletePlayerById(Long id);

}
