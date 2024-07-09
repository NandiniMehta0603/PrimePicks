package com.movie.primepicks.service;

import com.movie.primepicks.entity.Movie;
import com.movie.primepicks.entity.Preference;
import com.movie.primepicks.entity.User;
import com.movie.primepicks.repository.PreferenceRepository;
import com.movie.primepicks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private TMDBService tmdbService;

    public List<Movie> savePreference(String name, String gender, Integer age, String email,
                                      Integer action, Integer comedy, Integer horror,
                                      Integer thriller, Integer suspense) {

        // Save user preference
        Preference preference = new Preference(action, comedy, horror, thriller, suspense);
        preferenceRepository.save(preference);

        // Save user details
        User user = new User(name, gender, age, email);
        userRepository.save(user);

        // Get movies based on preference
        List<Movie> movies = tmdbService.getMoviesByGenre(getPreferredGenre(preference));

        // Attach trailers to movies
        if (movies != null) {
            for (Movie movie : movies) {
                String trailerLink = tmdbService.getTrailerByMovieId(movie.getId());
                movie.setTrailerLink(trailerLink);
            }
        }

        return movies;
    }

    private String getPreferredGenre(Preference preference) {
        int maxWeight = Math.max(preference.getAction(), Math.max(preference.getComedy(),
                Math.max(preference.getHorror(), Math.max(preference.getThriller(), preference.getSuspense()))));

        if (preference.getAction() == maxWeight) {
            return "Action";
        } else if (preference.getComedy() == maxWeight) {
            return "Comedy";
        } else if (preference.getHorror() == maxWeight) {
            return "Horror";
        } else if (preference.getThriller() == maxWeight) {
            return "Thriller";
        } else {
            return "Suspense";
        }
    }
}
