package com.example.kino_baza_polaczenie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "klient")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "klient_id")
    private int client_id;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String lastName;

    @Column(name = "email")
    private String email;


    public Client(int client_id, String name, String lastName, String email) {
        this.client_id = client_id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
}
