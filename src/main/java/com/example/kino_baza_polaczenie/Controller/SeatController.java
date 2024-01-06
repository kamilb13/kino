package com.example.kino_baza_polaczenie.Controller;

import com.example.kino_baza_polaczenie.Model.Seat;
import com.example.kino_baza_polaczenie.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/allseats")
    public List<Seat> getAllSeats(Model model) {
        //model.addAttribute("seats", seatRepository.findAll());
        return seatRepository.findAll();
    }
}
