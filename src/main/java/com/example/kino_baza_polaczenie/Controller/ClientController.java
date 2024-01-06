package com.example.kino_baza_polaczenie.Controller;

import com.example.kino_baza_polaczenie.Model.Client;
import com.example.kino_baza_polaczenie.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/allclients")
    public List<Client> getAllClients(Model model) {
        return clientRepository.findAll();
    }
}
