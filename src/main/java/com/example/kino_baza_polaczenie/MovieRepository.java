package com.example.kino_baza_polaczenie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //wsytrzykiwanie movierepositry
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // tutaj pierdoly
}
