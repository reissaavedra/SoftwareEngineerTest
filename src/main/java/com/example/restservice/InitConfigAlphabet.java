package com.example.restservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfigAlphabet {
    @Bean
    public Alphabet alphabet() {
        Alphabet alphabet = new Alphabet();
        String charsAlphabet = "abcdefghijklmnñopqrstuvwxyz";
        for (int i = 0, len = charsAlphabet.length(); i < len; i++) {
            String character = String.valueOf(charsAlphabet.charAt(i));
            alphabet.insert(character);
        }
        return alphabet;
    }
}
