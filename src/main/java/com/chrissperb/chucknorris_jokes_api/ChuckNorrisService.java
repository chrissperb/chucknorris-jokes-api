package com.chrissperb.chucknorris_jokes_api;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

    @Service
    public class ChuckNorrisService {

        private final RestTemplate restTemplate = new RestTemplate();
        private static final String API_URL = "https://api.chucknorris.io/jokes/random";

        public String getRandomJoke() {
            return restTemplate.getForObject(API_URL, String.class);
        }
    }