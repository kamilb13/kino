package com.example.kino_baza_polaczenie.model;

import java.time.LocalDate;

public class DirectorRequest {


    private String name;

    private String lastName;

    private LocalDate born;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }
}
