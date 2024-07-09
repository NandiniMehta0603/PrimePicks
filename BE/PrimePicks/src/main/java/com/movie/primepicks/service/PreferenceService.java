package com.movie.primepicks.service;

import com.movie.primepicks.entity.Preference;
import com.movie.primepicks.entity.User;
import com.movie.primepicks.repository.PreferenceRepository;
import com.movie.primepicks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PreferenceService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PreferenceRepository preferenceRepository;


    public void savePreference(String name, String gender, Integer age,
                               String email, Preference preference){
        //saving new user to db
        User user = new User(name,gender,age,email);
        userRepository.save(user);

        Integer userId=user.getUserId();
        preference.setId(userId);
        //saving new user's preference to db
        preferenceRepository.save(preference);

        //finding the maxi rating for the particular user
        Integer maxRating=preferenceRepository.findMaxRatingByUserId(userId);
        String preferredGenre=null;
        if(Objects.equals(preference.getAction(), maxRating)){
            preferredGenre="Action";
        }
        else if(Objects.equals(preference.getComedy(), maxRating)){
            preferredGenre="Comedy";
        }
        else if(Objects.equals(preference.getHorror(), maxRating)){
            preferredGenre="Horror";
        }
        else if(Objects.equals(preference.getThriller(), maxRating)){
            preferredGenre="Thriller";
        }
        else {
            preferredGenre="Suspense";
        }
        System.out.println(preferredGenre);
    }
}
