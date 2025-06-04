package com.frblmi.movies.controller;

import com.frblmi.movies.model.MovieDto;
import com.frblmi.movies.model.MovieTitleDto;
import com.frblmi.movies.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieTitleDto>> getAllMoviesByName(@RequestParam String name) {
        var movies = movieService.getAllMoviesByName(name);
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/id")
    public ResponseEntity<MovieDto> getMovieById(@RequestParam String id) {
        var movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }


}
