package com.porado.backend.security.service;

import com.porado.backend.model.Player;
import com.porado.backend.repository.PlayerRepository;
import com.porado.backend.security.model.CustomUserDetails;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PlayerRepository playerRepository;

    @Override
    public @NonNull UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username: " + ((username.isBlank())? "no username" : username));
        Player player = playerRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CustomUserDetails(player);
    }
}
