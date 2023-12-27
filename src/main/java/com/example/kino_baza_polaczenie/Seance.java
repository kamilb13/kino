package com.example.kino_baza_polaczenie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seans")
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seans_id")
    private int seance_id;

    @Column(name = "godzina")
    private LocalTime time;

    @Column(name = "data")
    private LocalDate dateId;

    @Column(name = "sala_sala_id")
    private int saleId;

    @Column(name = "film_film_id")
    private int movieId;
}
