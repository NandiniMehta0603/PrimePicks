package com.movie.primepicks.service;

import com.movie.primepicks.entity.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TMDBService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Movie> getMoviesByGenre(String genre) {
        String genreId = getGenreId(genre);
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + apiKey + "&with_genres=" + genreId;
        TMDBResponse response = restTemplate.getForObject(url, TMDBResponse.class);

        return response != null ? response.getResults().stream().limit(10).collect(Collectors.toList()) : null;
    }

    public String getTrailerByMovieId(String movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "/videos?api_key=" + apiKey;
        TMDBVideoResponse response = restTemplate.getForObject(url, TMDBVideoResponse.class);

        if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
            // Assuming the first result is the trailer
            return "https://www.youtube.com/watch?v=" + response.getResults().get(0).getKey();
        } else {
            return null;
        }
    }

    private String getGenreId(String genre) {
        switch (genre.toLowerCase()) {
            case "action":
                return "28";
            case "comedy":
                return "35";
            case "horror":
                return "27";
            case "thriller":
                return "53";
            case "suspense":
                return "9648";
            default:
                throw new IllegalArgumentException("Invalid genre: " + genre);
        }
    }

    private static class TMDBResponse {
        private List<Movie> results;

        public List<Movie> getResults() {
            return results;
        }

        public void setResults(List<Movie> results) {
            this.results = results;
        }
    }

    private static class TMDBVideoResponse {
        private List<TMDBVideo> results;

        public List<TMDBVideo> getResults() {
            return results;
        }

        public void setResults(List<TMDBVideo> results) {
            this.results = results;
        }
    }

    private static class TMDBVideo {
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
