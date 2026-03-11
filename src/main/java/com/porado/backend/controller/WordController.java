package com.porado.backend.controller;

import com.porado.backend.model.MessageResponse;
import com.porado.backend.service.WordService;
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
    public ResponseEntity<MessageResponse> getRandomWord() {
        return ResponseEntity.ok(new MessageResponse("Word: " + wordService.getRandomWord(5)));
    }

}
