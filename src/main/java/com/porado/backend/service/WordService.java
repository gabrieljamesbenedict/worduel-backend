package com.porado.backend.service;

import com.porado.backend.dto.Word;

public interface WordService {
    Word getRandomWord(int length);
}
