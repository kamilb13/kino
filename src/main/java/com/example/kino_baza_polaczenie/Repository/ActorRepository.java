package com.example.kino_baza_polaczenie.Repository;

import com.example.kino_baza_polaczenie.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}

