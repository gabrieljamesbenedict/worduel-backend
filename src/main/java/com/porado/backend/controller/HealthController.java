package com.porado.backend.controller;

import com.porado.backend.model.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<MessageResponse> healthcheck() {
        return ResponseEntity.ok(new MessageResponse("System is healthy!"));
    }

}
