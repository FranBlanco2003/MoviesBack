package com.frblmi.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Plot")
    private String plot;
}
