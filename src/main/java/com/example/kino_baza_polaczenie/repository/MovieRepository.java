package com.example.kino_baza_polaczenie.repository;

import com.example.kino_baza_polaczenie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //wsytrzykiwanie movierepositry
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // tutaj
}
