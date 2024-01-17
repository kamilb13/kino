package com.example.kino_baza_polaczenie;

import com.example.kino_baza_polaczenie.controller.ClientController;
import com.example.kino_baza_polaczenie.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClientControllerTest {

    private ClientController clientController;

    @BeforeEach
    void setUp() {
        // Inicjalizacja klientRepository jako mocka
        ClientRepository clientRepository = mock(ClientRepository.class);

        // Przykładowa lista klientów do zwrócenia przez mocka
        List<com.example.kino_baza_polaczenie.model.Client> clients = Arrays.asList(
                new com.example.kino_baza_polaczenie.model.Client(1, "John", "Doe", "john@example.com"),
                new com.example.kino_baza_polaczenie.model.Client(2, "Jane", "Doe", "jane@example.com")
        );

        // Konfiguracja zachowania mocka
        when(clientRepository.findAll()).thenReturn(clients);

        // Inicjalizacja kontrolera z mockiem repository
        clientController = new ClientController();
        clientController.setClientRepository(clientRepository);
    }

    @Test
    void testGetAllClients() {
        Model model = mock(Model.class);

        // Wywołanie metody kontrolera
        List<com.example.kino_baza_polaczenie.model.Client> result = clientController.getAllClients(model);

        // Sprawdzenie, czy lista klientów nie jest pusta
        assertEquals(2, result.size());
    }
}
