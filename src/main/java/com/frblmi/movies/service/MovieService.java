package com.frblmi.movies.service;

import com.frblmi.movies.model.MovieDto;
import com.frblmi.movies.model.MovieListResponse;
import com.frblmi.movies.model.MovieTitleDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class MovieService {

    private final RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    public MovieService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public List<MovieTitleDto> getAllMoviesByName(String name) {
        String encodedName = UriUtils.encode(name, StandardCharsets.UTF_8);
        String url = String.format("http://www.omdbapi.com/?apikey=%s&s=%s", apiKey, encodedName);
        System.out.println("Request URL: " + url);

        MovieListResponse response = restTemplate.getForObject(url, MovieListResponse.class);

        if (response != null && "True".equalsIgnoreCase(response.getResponse())) {
            return response.getMovies();
        } else {
            System.out.println("Error from API: " + (response != null ? response.getError() : "null response"));
            return List.of(); // vacío si falla
        }
    }


    public MovieDto getMovieById(String id) {
        String encodedId = UriUtils.encode(id, StandardCharsets.UTF_8);
        String url = String.format("http://www.omdbapi.com/?apikey=%s&i=%s", apiKey, encodedId);
        System.out.println("Request URL: " + url);
        return restTemplate.getForObject(url, MovieDto.class);
    }
}
