package com.example.kino_baza_polaczenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
