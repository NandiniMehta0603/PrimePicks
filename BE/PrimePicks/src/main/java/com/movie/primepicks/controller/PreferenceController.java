package com.movie.primepicks.controller;

import com.movie.primepicks.entity.Movie;
import com.movie.primepicks.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @GetMapping("/temp")
    public String temporary() {
        return "Hello";
    }

    @GetMapping("/preference")
    public ResponseEntity<List<Movie>> savePreference(@RequestParam String name,
                                                      @RequestParam String gender,
                                                      @RequestParam Integer age,
                                                      @RequestParam String email,
                                                      @RequestParam Integer thriller,
                                                      @RequestParam Integer action,
                                                      @RequestParam Integer horror,
                                                      @RequestParam Integer suspense,
                                                      @RequestParam Integer comedy) {

        List<Movie> movies = preferenceService.savePreference(name, gender, age, email, action, comedy, horror, thriller, suspense);

        if (movies == null || movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(movies);
        }
    }
}
