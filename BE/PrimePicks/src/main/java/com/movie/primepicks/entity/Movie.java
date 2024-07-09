package com.movie.primepicks.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    private String id;
    private String title;
    private String overview;

    @JsonProperty("release_date")
    private String releaseDate;
    private String trailerLink;

    // Constructors, getters, and setters

    public Movie() {
    }

    public Movie(String id, String title, String overview, String releaseDate, String trailerLink) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }

    @Override
    public String toString() {
        return "Movie{" +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", trailerLink='" + trailerLink + '\'' +
                '}';
    }
}
