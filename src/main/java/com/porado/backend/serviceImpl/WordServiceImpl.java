package com.porado.backend.serviceImpl;

import com.porado.backend.dto.Word;
import com.porado.backend.repository.WordRepository;
import com.porado.backend.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

    @Override
    public Word getRandomWord(int length) {
        Word word = null;
        try {
            word = wordRepository.getRandomWord(length);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        return word;
    }
}
