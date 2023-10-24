package com.example.kino_baza_polaczenie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private int duration;

    public Movie(String name) {
        this.name = name;
    }
    public Movie(int duration, String name, String type) {
        this.name = name;
        this.type = type;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", duration=" + duration +
                '}';
    }
}
