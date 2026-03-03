package com.porado.backend.serviceImpl;

import com.porado.backend.dto.*;
import com.porado.backend.security.JwtUtil;
import com.porado.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public AuthToken login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
            )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        assert userDetails != null;
        return new AuthToken(jwtUtil.generateToken(userDetails));
    }

    @Override
    public MessageResponse logout() {
        return new MessageResponse("Logged out successfully");
    }

    @Override
    public MessageResponse register(RegisterRequest registerRequest) {
        return null;
    }

    @Override
    public UserInfo me() {
        return null;
    }
}
