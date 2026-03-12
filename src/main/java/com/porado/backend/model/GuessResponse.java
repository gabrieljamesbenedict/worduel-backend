package com.porado.backend.model;


import com.porado.core.util.LetterType;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class GuessResponse {

    private UUID playerId;
    private final String guess;
    private final String target;
    private final List<LetterType> position;

}
