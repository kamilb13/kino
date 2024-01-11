package com.example.kino_baza_polaczenie.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class SeanceRequest {
    private LocalTime time;
    private LocalDate dateId;
    private int saleId;
    private int movieId;


    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDateId() {
        return dateId;
    }

    public void setDateId(LocalDate dateId) {
        this.dateId = dateId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
