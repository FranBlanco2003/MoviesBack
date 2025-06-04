package com.frblmi.movies.service;

import com.frblmi.movies.client.OmdbClient;
import com.frblmi.movies.model.MovieDto;
import com.frblmi.movies.model.MovieListResponse;
import com.frblmi.movies.model.MovieTitleDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;


@Service
public class MovieService {

    private final OmdbClient omdbClient;
    private final String apiKey;

    public MovieService(OmdbClient omdbClient, @Value("${api.key}") String apiKey) {
        this.omdbClient = omdbClient;
        this.apiKey = apiKey;
    }

    public List<MovieTitleDto> getAllMoviesByName(String name) {
        String encodedName = UriUtils.encode(name, StandardCharsets.UTF_8);
        MovieListResponse response = omdbClient.searchMoviesByTitle(apiKey, encodedName);
        if (response != null && "True".equalsIgnoreCase(response.getResponse())) {
            return response.getMovies();
        } else {
            throw new RuntimeException("No movies found with the name: " + name);
        }
    }

    public MovieDto getMovieById(String id) {
        String encodedId = UriUtils.encode(id, StandardCharsets.UTF_8);
        MovieDto movie = omdbClient.getMovieById(apiKey, encodedId);
        if (movie != null) {
            return movie;
        } else {
            throw new RuntimeException("No movie found with the ID: " + id);
        }
    }
}

