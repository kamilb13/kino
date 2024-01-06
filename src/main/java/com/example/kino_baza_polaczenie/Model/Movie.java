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
@Table(name = "film")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int id;
    @Column(name = "tytul")
    private String name;
    @Column(name = "opis")
    private String description;
    @Column(name = "data_premiery")
    private LocalDate premier_date;

    public Movie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Movie(String name, String description, LocalDate premier_date) {
        this.name = name;
        this.description = description;
        this.premier_date = premier_date;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", premier_date=" + premier_date +
                '}';
    }
}