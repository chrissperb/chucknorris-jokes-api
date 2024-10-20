package com.chrissperb.chucknorris_jokes_api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChuckNorrisService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://api.chucknorris.io/jokes/random";
    private static final String DEEPL_API_URL = "https://api-free.deepl.com/v2/translate";

    @Value("${deepl.api.key}")
    private String deeplApiKey;

    public String getRandomJoke() {
        String joke = restTemplate.getForObject(API_URL, String.class);
        return translateToPortuguese(joke);
    }

    private String translateToPortuguese(String text) {
        String url = DEEPL_API_URL + "?auth_key=" + deeplApiKey +
                "&text=" + text + "&target_lang=PT";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }
}
