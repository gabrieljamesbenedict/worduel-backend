package com.porado.backend.serviceImpl;

import com.porado.backend.model.Player;
import com.porado.backend.repository.PlayerRepository;
import com.porado.backend.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepo;

    @Override
    public Optional<Player> getPlayerById(Long id) {
        return playerRepo.findById(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepo.save(player);
    }

    @Override
    public Player updatePlayer(Long id, Player player) {
        if (!playerRepo.existsById(id)) {
            throw new RuntimeException("Player not found with id " + id);
        }
        return playerRepo.save(player);
    }

    @Override
    public void deletePlayerById(Long id) {
        if (!playerRepo.existsById(id)) {
            throw new RuntimeException("Player not found with id " + id);
        }
        playerRepo.deleteById(id);
    }
}
