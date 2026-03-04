package com.porado.backend.service;

import com.porado.backend.dto.*;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    AuthToken login(LoginRequest loginRequest);
    MessageResponse logout();
    MessageResponse register(RegisterRequest registerRequest);
    UserInfo me();
}
