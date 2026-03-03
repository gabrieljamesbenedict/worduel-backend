package com.porado.backend.service;

import com.porado.backend.dto.*;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<AuthToken> login(LoginRequest loginRequest);
    ResponseEntity<?> logout();
    ResponseEntity<MessageResponse> register(RegisterRequest registerRequest);
    ResponseEntity<UserInfo> me();
}
