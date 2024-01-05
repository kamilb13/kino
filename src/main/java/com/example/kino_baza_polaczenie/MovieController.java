package com.example.kino_baza_polaczenie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Musi byc inaczej serwery się nie widzą chyba?
@RestController
//@RequestMapping("/api/movies") //dla calej kalasy endpoint
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/filmy")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/film/{id}")
    public Movie getMovieById(@PathVariable long id) {
        return movieRepository.findById(id).orElse(null);
    }
}