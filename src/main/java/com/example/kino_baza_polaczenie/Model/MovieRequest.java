package com.example.kino_baza_polaczenie.Model;

import java.time.LocalDate;

public class MovieRequest {
    private String name;
    private String description;
    private LocalDate premier_date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPremier_date() {
        return premier_date;
    }

    public void setPremier_date(LocalDate premier_date) {
        this.premier_date = premier_date;
    }
}
