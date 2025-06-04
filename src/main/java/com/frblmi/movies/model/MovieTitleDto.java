package com.frblmi.movies.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieTitleDto {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("imdbID")
    private String imdbID;
}


