package com.example.kino_baza_polaczenie.repository;

import com.example.kino_baza_polaczenie.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}

