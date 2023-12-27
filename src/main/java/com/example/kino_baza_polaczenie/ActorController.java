package com.example.kino_baza_polaczenie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ActorController {

    @Autowired
    ActorRepository actorRepository;
/*
        List<Movie> filmy = movieRepository.findAll();
        model.addAttribute("filmy", filmy);
        System.out.println("Liczba filmów w modelu: " + filmy.size());
        return "allMovies"; // To odnosi się do pliku allMovies.html
 */
    @GetMapping("/allActors")
    public List<Actor> allActors(Model model){
//        List<Actor> actors = actorRepository.findAll();
//        model.addAttribute("actors", actors);
//        return "actors";
        return actorRepository.findAll();
    }

    @GetMapping("/actors/{id}")
    public String getActorById(@PathVariable long id, Model model){
        Actor actor;
        actor = actorRepository.findById(id).orElse(null);
        model.addAttribute("actor", actor);
        /*TODO
        dokonczyc
        */
        return null;
    }

}
