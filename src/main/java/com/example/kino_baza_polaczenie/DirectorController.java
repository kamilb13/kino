package com.example.kino_baza_polaczenie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Musi byc inaczej serwery się nie widzą chyba?
@RestController
public class DirectorController {

    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping("/alldirectors")
    public List<Director> getAllDirectors(Model model) {
        //model.addAttribute("directors", directorRepository.findAll());
        return directorRepository.findAll();
    }
}
