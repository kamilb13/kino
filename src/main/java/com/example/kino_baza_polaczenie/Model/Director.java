package com.example.kino_baza_polaczenie.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rezyser")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rezyser_id")
    private int director_id;
    @Column(name = "imie")
    private String name;
    @Column(name = "nazwisko")
    private String lastName;
    @Column(name = "rok_urodzenia")
    private LocalDate born;

    public Director(String name, String lastName, LocalDate born) {
        this.name = name;
        this.lastName = lastName;
        this.born = born;
    }
}
