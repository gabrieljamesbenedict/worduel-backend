package com.porado.backend.service;

import com.porado.backend.model.Word;

public interface WordService {
    Word getRandomWord(int length);
}
