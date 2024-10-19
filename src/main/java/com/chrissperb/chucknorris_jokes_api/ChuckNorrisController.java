package com.chrissperb.chucknorris_jokes_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChuckNorrisController {

    @Autowired
    private ChuckNorrisService chuckNorrisService;

    @GetMapping("/joke")
    public String getRandomJoke() {
        return chuckNorrisService.getRandomJoke();
    }
}
