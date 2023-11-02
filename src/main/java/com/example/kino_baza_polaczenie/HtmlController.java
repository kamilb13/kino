package com.example.kino_baza_polaczenie;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HtmlController {
    private final MovieRepository movieRepository;

    public HtmlController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public String exampleView(Model model) {
        model.addAttribute("message", "Kino");
        return "index"; //nazwa pliku html
    }
    @GetMapping("/wszystkie-filmy")
    public String wszystkieFilmy(Model model) {
        List<Movie> filmy = movieRepository.findAll();
        model.addAttribute("filmy", filmy);
        System.out.println("Liczba filmów w modelu: " + filmy.size());
        return "allMovies"; // To odnosi się do pliku allMovies.html
    }

    @GetMapping("/dodaj-film-form")
    public String dodajFilmForm(Model model) {
        return "dodaj-film"; //nazwa pliku html z formularzem
    }

    @PostMapping("/dodaj-film")
    public String dodajFilm(@RequestParam String name, @RequestParam String type, @RequestParam int duration) {
        Movie film = new Movie(duration ,name, type);
        movieRepository.save(film);
        return "redirect:/wszystkie-filmy"; // Przekierowanie na stronę z listą filmów
    }

}