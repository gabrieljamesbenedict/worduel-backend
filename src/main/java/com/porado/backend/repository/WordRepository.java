package com.porado.backend.repository;

import com.porado.backend.dto.Word;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import tools.jackson.core.json.JsonFactory;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Repository
public class WordRepository {

    private static final String FILE_PATH = "static/words_dictionary.json";
    private final ClassPathResource resource = new ClassPathResource(FILE_PATH);
    private final JsonFactory factory = new JsonFactory();


    private Set wordSet = null;
    private Integer sizeOfSet = null;

    public Word getRandomWord(int length) throws IOException {
        if (wordSet == null) instantiateWordSet();
        Random rand = new Random();
        String wordStr = "";
        do {
            wordStr = (String)wordSet.toArray()[rand.nextInt(sizeOfSet)];
        } while(wordStr.length() != length);
        return new Word(wordStr);
    }

    private void instantiateWordSet() throws IOException {
        try (InputStream stream = resource.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            Map dictionary = mapper.readValue(stream, Map.class);
            wordSet = dictionary.keySet();
            sizeOfSet = dictionary.size();
        }
    }
}
