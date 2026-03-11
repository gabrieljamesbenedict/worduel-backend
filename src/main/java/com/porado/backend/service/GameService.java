package com.porado.backend.service;


import java.util.UUID;

public interface GameService {
    void createGame();
    void joinGame(UUID gameRoomId);
}
