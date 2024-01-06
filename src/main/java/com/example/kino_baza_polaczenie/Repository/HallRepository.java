package com.example.kino_baza_polaczenie.Repository;

import com.example.kino_baza_polaczenie.Model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {

}

