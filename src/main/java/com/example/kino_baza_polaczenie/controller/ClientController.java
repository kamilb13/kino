package com.example.kino_baza_polaczenie.controller;

import com.example.kino_baza_polaczenie.model.Client;
import com.example.kino_baza_polaczenie.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/allclients")
    public List<Client> getAllClients(Model model) {
        return clientRepository.findAll();
    }
}
