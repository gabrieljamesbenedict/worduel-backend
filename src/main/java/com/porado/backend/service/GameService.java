package com.porado.backend.service;


import com.porado.core.game.GameRoom;

import java.util.List;
import java.util.UUID;

public interface GameService {
    List<GameRoom> viewAllRooms();
    GameRoom createSoloRoom();
    GameRoom createDuelRoom();
    void destroyRoom(UUID roomId);
}
