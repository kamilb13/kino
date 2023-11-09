package com.example.kino_baza_polaczenie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.List;


@RestController
//@RequestMapping("/api/movies") //dla calej kalasy endpoint
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //    @GetMapping("/")
//    public String home(){
//        return String.format("KINO");
//    }
    @GetMapping("/filmy")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    @GetMapping("/film/{id}")
    public String getMovieById(@PathVariable long id) {
        return movieRepository.findById(id).orElse(null).toString();
    }
    /*
    @GetMapping("/dodaj-film/{name}")
    public Movie addMovie(@PathVariable String name){
        Movie film = new Movie(name, 120, "Crime");
        return movieRepository.save(film);
    }
     */
}