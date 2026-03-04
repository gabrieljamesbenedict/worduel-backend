package com.porado.backend.serviceImpl;

import com.porado.backend.dto.*;
import com.porado.backend.exception.LoginException;
import com.porado.backend.exception.UserAlreadyExistsException;
import com.porado.backend.exception.UserNotFoundException;
import com.porado.backend.model.User;
import com.porado.backend.repository.UserRepository;
import com.porado.backend.security.JwtUtil;
import com.porado.backend.service.AuthService;
import com.porado.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public AuthToken login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return new AuthToken(jwtUtil.generateToken(userDetails));
        } catch (AuthenticationException e) {
            throw new LoginException("Invalid username or password");
        }
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found with username=" + username));

        return new UserInfo(user);
    }
}
