package com.example.kino_baza_polaczenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000") // Musi byc inaczej serwery się nie widzą chyba?
//@RequestMapping("/admin")
public class AdminController {

    private final MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;

    public AdminController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/admin")
    public String admin(Model model){
        List<Movie> filmy = movieRepository.findAll();
        List<Actor> actors = actorRepository.findAll();
        model.addAttribute("filmy", filmy);
        model.addAttribute("actors", actors);
        return "admin";
    }

    @GetMapping("/adminpanel")
    public String adminPanel(Model model){
        List<Movie> filmy = movieRepository.findAll();
        List<Actor> actors = actorRepository.findAll();
        model.addAttribute("filmy", filmy);
        model.addAttribute("actors", actors);
        return "adminpanel";
    }

    @GetMapping("/dodaj-film-form")
    public String dodajFilmForm(Model model) {
        return "dodaj-film"; //nazwa pliku html z formularzem
    }

    @PostMapping("/dodaj-film")
    public void dodajFilm(@RequestBody MovieRequest movieRequest) {
        Movie film = new Movie(movieRequest.getName(), movieRequest.getDescription(), movieRequest.getPremier_date());
        movieRepository.save(film);

    }
}
