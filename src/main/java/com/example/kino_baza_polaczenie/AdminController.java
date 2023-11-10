package com.example.kino_baza_polaczenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class AdminController {

    private final MovieRepository movieRepository;

    public AdminController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/admin")
    public String adminPanel(Model model){
        List<Movie> filmy = movieRepository.findAll();
        model.addAttribute("filmy", filmy);
        return "admin";
    }

    @GetMapping("/dodaj-film-form")
    public String dodajFilmForm(Model model) {
        return "dodaj-film"; //nazwa pliku html z formularzem
    }

    @PostMapping("/dodaj-film")
    public String dodajFilm(@RequestParam String name, @RequestParam String description, @RequestParam LocalDate premier_date) {
        Movie film = new Movie(name, description, premier_date);
        movieRepository.save(film);
        return "redirect:/"; // Przekierowanie na stronę z listą filmów
    }

    
}
