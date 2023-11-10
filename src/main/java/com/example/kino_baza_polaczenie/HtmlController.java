package com.example.kino_baza_polaczenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HtmlController {
    @Autowired
    private MovieRepository movieRepository;
/*
    public HtmlController(MovieRepository movieRepository) {  //dzieki Autowirde nie musze pisac konstruktora
        this.movieRepository = movieRepository;
    }

 */

    @GetMapping("/")
    public String exampleView(Model model) {
        //model.addAttribute("message", "Kino");
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