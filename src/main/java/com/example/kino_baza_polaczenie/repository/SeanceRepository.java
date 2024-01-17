package com.example.kino_baza_polaczenie.repository;

import com.example.kino_baza_polaczenie.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {

}

