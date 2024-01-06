package com.example.kino_baza_polaczenie.Controller;

import com.example.kino_baza_polaczenie.Model.Seance;
import com.example.kino_baza_polaczenie.Repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
