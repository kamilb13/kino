package com.example.kino_baza_polaczenie.controller;
import com.example.kino_baza_polaczenie.repository.ActorRepository;
import com.example.kino_baza_polaczenie.model.Movie;
import com.example.kino_baza_polaczenie.model.MovieRequest;
import com.example.kino_baza_polaczenie.model.Actor;
import com.example.kino_baza_polaczenie.model.Seance;
import com.example.kino_baza_polaczenie.model.ActorRequest;
import com.example.kino_baza_polaczenie.model.Director;
import com.example.kino_baza_polaczenie.model.DirectorRequest;
import com.example.kino_baza_polaczenie.model.Hall;
import com.example.kino_baza_polaczenie.model.HallRequest;
import com.example.kino_baza_polaczenie.model.SeanceRequest;
import com.example.kino_baza_polaczenie.repository.DirectorRepository;
import com.example.kino_baza_polaczenie.repository.MovieRepository;
import com.example.kino_baza_polaczenie.repository.HallRepository;
import com.example.kino_baza_polaczenie.repository.SeanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000") // Musi byc inaczej serwery się nie widzą chyba?
//@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private final MovieRepository movieRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private SeanceRepository seanceRepository;

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

    @PostMapping("/dodaj-aktora")
    public String dodajAktora(@RequestBody ActorRequest actorRequest) {
        Actor actor = new Actor(actorRequest.getName(), actorRequest.getLastName(), actorRequest.getBorn(), actorRequest.getSalary());
        actorRepository.save(actor);
        return "redirect:/";
    }

    @PostMapping("/dodaj-rezysera")
    public String dodajRezysera(@RequestBody DirectorRequest directorRequest){
        Director director = new Director(directorRequest.getName(), directorRequest.getLastName(), directorRequest.getBorn());
        directorRepository.save(director);
        return "redirect:/";
    }

    @PostMapping("/dodaj-sale")
    public String dodajSale(@RequestBody HallRequest hallRequest){
        Hall hall = new Hall(hallRequest.getName(), hallRequest.getSeats_number(), hallRequest.getEntry_number());
        hallRepository.save(hall);
        return "redirect:/";
    }

    @PostMapping("/dodaj-seans")
    public String dodajSale(@RequestBody SeanceRequest seanceRequest){
        Seance seance = new Seance(seanceRequest.getTime(), seanceRequest.getDateId(), seanceRequest.getSaleId(), seanceRequest.getMovieId());
        seanceRepository.save(seance);
        return "redirect:/";
    }
}
