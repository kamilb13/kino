package com.example.kino_baza_polaczenie.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bilet")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bilet_id")
    private int ticket_id;

    @Column(name = "cena")
    private float value;

    @Column(name = "klient_klient_id")
    private int clientId;

    @Column(name = "seans_seans_id")
    private int seanceId;

    @Column(name = "miejsce_miejsce_id")
    private int seatId;


}

