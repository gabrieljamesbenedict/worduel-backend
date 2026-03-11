package com.porado.backend.model;


import com.porado.core.util.LetterType;
import lombok.Data;

import java.util.List;

@Data
public class GuessResponse {

    private final String guess;
    private final List<LetterType> position;

}
