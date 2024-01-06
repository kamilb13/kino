package com.example.kino_baza_polaczenie.Repository;

import com.example.kino_baza_polaczenie.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}

