package com.example.kino_baza_polaczenie.model;

import java.time.LocalDate;

public class ActorRequest {

    private  String name;
    private String lastName;
    private LocalDate born;
    private double salary;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
