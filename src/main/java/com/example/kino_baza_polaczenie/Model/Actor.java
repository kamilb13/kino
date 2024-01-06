package com.example.kino_baza_polaczenie.Model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aktor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aktor_id")
    private int actor_id;
    @Column(name = "imie")
    private String name ;
    @Column(name = "nazwisko")
    private String lastName;
    @Column(name = "data_urodzenia")
    private LocalDate born;
    @Column(name = "wynagrodzenie")
    private double salary ;


    public Actor(String name, String lastName, LocalDate born, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.born = born;
        this.salary = salary;
    }
}
