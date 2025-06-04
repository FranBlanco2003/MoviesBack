package com.frblmi.movies.client;

import com.frblmi.movies.model.MovieDto;
import com.frblmi.movies.model.MovieListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdbClient", url = "${api.url}")
public interface OmdbClient {

    @GetMapping("/")
    MovieListResponse searchMoviesByTitle(@RequestParam("apikey") String apiKey,
                                          @RequestParam("s") String title);

    @GetMapping("/")
    MovieDto getMovieById(@RequestParam("apikey") String apiKey,
                          @RequestParam("i") String id);
}
