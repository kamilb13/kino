package com.example.kino_baza_polaczenie.controller;
import com.example.kino_baza_polaczenie.model.Actor;
import com.example.kino_baza_polaczenie.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ActorController {

    @Autowired
    ActorRepository actorRepository;

    @GetMapping("/allActors")
    public List<Actor> allActors(Model model){
        return actorRepository.findAll();
    }

    @GetMapping("/actors/{id}")
    public String getActorById(@PathVariable long id, Model model){
        Actor actor;
        actor = actorRepository.findById(id).orElse(null);
        model.addAttribute("actor", actor);
        /*TODO
        dokonczyc w przyszlosci
        */
        return null;
    }

}
