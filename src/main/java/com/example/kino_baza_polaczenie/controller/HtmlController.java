package com.example.kino_baza_polaczenie.controller;

import com.example.kino_baza_polaczenie.model.Movie;
import com.example.kino_baza_polaczenie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HtmlController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public String exampleView(Model model) {
        List<Movie> filmy = movieRepository.findAll();
        model.addAttribute("filmy", filmy);
        return "index"; //nazwa pliku html
    }
    @GetMapping("/wszystkie-filmy")
    public String wszystkieFilmy(Model model) {
        List<Movie> filmy = movieRepository.findAll();
        model.addAttribute("filmy", filmy);
        System.out.println("Liczba filmów w modelu: " + filmy.size());
        return "allMovies"; // To odnosi się do pliku allMovies.html
    }
}