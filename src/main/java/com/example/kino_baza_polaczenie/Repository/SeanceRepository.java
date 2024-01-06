package com.example.kino_baza_polaczenie.Repository;

import com.example.kino_baza_polaczenie.Model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {

}

