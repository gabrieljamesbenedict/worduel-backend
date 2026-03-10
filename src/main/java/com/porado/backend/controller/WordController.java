package com.porado.backend.controller;

import com.porado.backend.dto.Word;
import com.porado.backend.service.WordService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/words")
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;

    @GetMapping("/random")
    public ResponseEntity<Word> getRandomWord() {
        return ResponseEntity.ok(wordService.getRandomWord(5));
    }

}
