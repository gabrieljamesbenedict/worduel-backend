package com.porado.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.porado.backend", "com.porado.core", "com.porado.kafka"})
public class WorduelBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorduelBackendApplication.class, args);
	}

}
