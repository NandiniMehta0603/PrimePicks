package com.movie.primepicks.controller;

import com.movie.primepicks.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.movie.primepicks.entity.Preference;

@RestController
public class PreferenceController {
    @Autowired
    PreferenceService preferenceService;

    @GetMapping("/temp")
    public String temporary(){
        return "Hello";
    }
    @PostMapping("/preference")
    public void savePreference(@RequestParam String name,
                               @RequestParam String gender,
                               @RequestParam Integer age,
                               @RequestParam String email,
                               @RequestParam Integer thriller,
                               @RequestParam Integer action,
                               @RequestParam Integer horror,
                               @RequestParam Integer suspense,
                               @RequestParam Integer comedy
//                               @RequestBody Preference preference
    ) {
        Preference preference=new Preference(action,comedy,horror,thriller,suspense);
        preferenceService.savePreference(name,gender,age,email, preference);
    }
}
