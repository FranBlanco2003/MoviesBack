package com.frblmi.movies.controller;

import com.frblmi.movies.model.Movie;
import com.frblmi.movies.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name") String name) {
        Movie movie = movieService.searchByName(name);
        return name != null ? ResponseEntity.ok(movie) : ResponseEntity.notFound().build();
    }

}
