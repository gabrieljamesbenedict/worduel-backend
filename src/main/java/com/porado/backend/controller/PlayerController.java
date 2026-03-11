package com.porado.backend.controller;

import com.porado.backend.domain.Player;
import com.porado.backend.model.NicknameRequest;
import com.porado.backend.service.PlayerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/nickname")
    public ResponseEntity<Player> setNickname(HttpServletRequest request, @RequestBody NicknameRequest payload) {
        String id = (String) request.getAttribute("playerId");
        UUID playerId = UUID.fromString(id);
        Player player = playerService.getOrCreatePlayer(playerId);
        player.setNickname(payload.getNickname());
        return ResponseEntity.ok(player);
    }

}
