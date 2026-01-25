package com.porado.backend.security.controller;

import com.porado.backend.model.Player;
import com.porado.backend.repository.PlayerRepository;
import com.porado.backend.repository.PlayerRoleRepository;
import com.porado.backend.security.model.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpResponse;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final PlayerRepository playerRepository;
    private final PlayerRoleRepository playerRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    private ResponseEntity<?> registerPlayer(@RequestBody RegistrationRequest registrationRequest) {
        if (playerRepository.existsByUsername(registrationRequest.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken");
        }

        Player newPlayer = Player.builder()
                .username(registrationRequest.getUsername())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .role(playerRoleRepository.findById(1L).orElseThrow(() -> new IllegalStateException("Role not found")))
                .enabled(true)
                .build();
        playerRepository.save(newPlayer);

        return ResponseEntity.ok("User registered successfully");
    }

}
