package com.example.kino_baza_polaczenie.model;

public class HallRequest {
    String name;
    int seats_number;
    int entry_number;

    public HallRequest(String name, int seats_number, int entry_number) {
        this.name = name;
        this.seats_number = seats_number;
        this.entry_number = entry_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats_number() {
        return seats_number;
    }

    public void setSeats_number(int seats_number) {
        this.seats_number = seats_number;
    }

    public int getEntry_number() {
        return entry_number;
    }

    public void setEntry_number(int entry_number) {
        this.entry_number = entry_number;
    }
}