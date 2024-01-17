package com.example.kino_baza_polaczenie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "miejsce")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "miejsce_id")
    private int seat_id;

    @Column(name = "numer_miejsca")
    private int seatNumber;

    @Column(name = "sala_sala_id")
    private int hallId;
}
