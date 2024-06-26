package com.example.kino_baza_polaczenie.controller;

import com.example.kino_baza_polaczenie.model.Ticket;
import com.example.kino_baza_polaczenie.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/alltickets")
    public List<Ticket> getAllTickets(Model model) {
        return ticketRepository.findAll();
    }
}
