package com.porado.backend.serviceImpl;

import com.porado.backend.service.GameService;
import com.porado.core.manager.GameRoomManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRoomManager gameRoomManager;


    @Override
    public void createGame() {

    }

    @Override
    public void joinGame(UUID gameRoomId) {

    }
}
