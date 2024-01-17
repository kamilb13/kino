package com.example.kino_baza_polaczenie.controller;

import com.example.kino_baza_polaczenie.model.Seance;
import com.example.kino_baza_polaczenie.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Musi byc inaczej serwery się nie widzą chyba?
@RestController
public class SeanceController {

    @Autowired
    private SeanceRepository seanceRepository;

    @GetMapping("/allseances")
    public List<Seance> getAllseances(Model model) {
        model.addAttribute("seances", seanceRepository.findAll());
        return seanceRepository.findAll();
    }
}
