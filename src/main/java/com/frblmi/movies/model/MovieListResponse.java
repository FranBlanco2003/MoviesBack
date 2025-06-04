package com.frblmi.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MovieListResponse {

    @JsonProperty("Search")
    private List<MovieTitleDto> movies;

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Error")
    private String error;
}
