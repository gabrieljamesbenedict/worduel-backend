package com.porado.backend.serviceImpl;

import com.porado.backend.repository.WordRepository;
import com.porado.backend.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

    @Override
    public String getRandomWord(int length) {
        try {
            return wordRepository.getRandomWord(length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
