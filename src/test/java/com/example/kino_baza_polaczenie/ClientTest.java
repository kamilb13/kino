package com.example.kino_baza_polaczenie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.kino_baza_polaczenie.model.Client;
import org.junit.jupiter.api.Test;

class ClientTest {

    @Test
    void testClientConstructor() {
        // Utwórz obiekt klienta
        Client client = new Client(1, "John", "Doe", "john@example.com");

        // Sprawdź, czy pola obiektu są ustawione prawidłowo
        assertEquals(1, client.getClient_id());
        assertEquals("John", client.getName());
        assertEquals("Doe", client.getLastName());
        assertEquals("john@example.com", client.getEmail());
    }
}
