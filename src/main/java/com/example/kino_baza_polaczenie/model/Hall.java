package com.example.kino_baza_polaczenie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sala")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sala_id")
    private int hall_id;
    @Column(name = "nazwa")
    private String name;
    @Column(name = "miejsca")
    private int seats_number;
    @Column(name = "ilosc_wejsc")
    private int entry_number;


    public Hall(String name, int seats_number, int entry_number) {
        this.name = name;
        this.seats_number = seats_number;
        this.entry_number = entry_number;
    }
}
