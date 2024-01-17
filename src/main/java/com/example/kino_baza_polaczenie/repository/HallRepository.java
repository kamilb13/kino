package com.example.kino_baza_polaczenie.repository;

import com.example.kino_baza_polaczenie.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {

}

