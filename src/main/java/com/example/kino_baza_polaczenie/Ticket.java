package com.example.kino_baza_polaczenie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bilet")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bilet_id")
    private int tikcet_id;
    @Column(name = "cena")
    private String price ;
    @Column(name = "klient_klient_id")
    private int client_fk;
    @Column(name = "seans_seans_id")
    private LocalDate seance_fk;
    @Column(name = "miejsce_miejsce_id")
    private float seat_fk ;
}
