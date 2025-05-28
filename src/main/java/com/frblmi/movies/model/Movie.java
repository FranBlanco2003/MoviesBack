package com.frblmi.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movie {
    private String Title;
    private String Year;
    private String Director;
    private String Plot;
    private String Poster;
    private String imdbID;
    private String imdbRating;
}