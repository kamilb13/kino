package com.example.kino_baza_polaczenie.Controller;

import com.example.kino_baza_polaczenie.Model.Hall;
import com.example.kino_baza_polaczenie.Repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HallController {

    @Autowired
    private HallRepository hallRepository;

    @GetMapping("/allhalls")
    public List<Hall> getAllHalls(Model model) {
        return hallRepository.findAll();
    }
}
