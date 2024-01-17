package com.example.kino_baza_polaczenie.repository;

import com.example.kino_baza_polaczenie.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}

