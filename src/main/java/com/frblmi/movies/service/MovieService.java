package com.frblmi.movies.service;

import com.frblmi.movies.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

@Service
public class MovieService {

    private final RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    public MovieService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Movie searchByName(String name) {
        String encodedName = UriUtils.encode(name, StandardCharsets.UTF_8);
        String url = String.format("http://www.omdbapi.com/?apikey=%s&t=%s", apiKey, encodedName);
        return restTemplate.getForObject(url, Movie.class);
    }


}
