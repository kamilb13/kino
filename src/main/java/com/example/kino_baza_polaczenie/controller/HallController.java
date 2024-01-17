package com.example.kino_baza_polaczenie.controller;

import com.example.kino_baza_polaczenie.model.Hall;
import com.example.kino_baza_polaczenie.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HallController {

    @Autowired
    private HallRepository hallRepository;

    @GetMapping("/allhalls")
    public List<Hall> getAllHalls(Model model) {
        return hallRepository.findAll();
    }
}
