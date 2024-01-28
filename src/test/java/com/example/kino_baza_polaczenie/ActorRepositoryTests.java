package com.example.kino_baza_polaczenie;

import com.example.kino_baza_polaczenie.model.Actor;
import com.example.kino_baza_polaczenie.repository.ActorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ActorRepositoryTests {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    public void testSaveActor() {
        Actor actor = new Actor("Rado", "Kopi", LocalDate.of(2005, 1, 19), 55555.0);
        Actor savedActor = actorRepository.save(actor);
        assertEquals(actor, savedActor);
    }

    @Test
    public void testFindAllActors() {
        List<Actor> actors = actorRepository.findAll();
        assertNotEquals(-1, actors.size());
    }

    @Test
    public void testFindActorById() {
        Actor actor = new Actor("Kapi", "Sylwi", LocalDate.of(2002, 2, 19), 452354.0);
        actorRepository.save(actor);
        Optional<Actor> foundActorOptional = actorRepository.findById((long) actor.getActor_id());
        assertTrue(foundActorOptional.isPresent());
        assertEquals(actor, foundActorOptional.get());
    }

    @Test
    public void testDeleteActor() {
        Actor actor = new Actor("Kamcio", "Brzozi", LocalDate.of(2000, 10, 15), 51244.0);
        actorRepository.save(actor);
        actorRepository.delete(actor);
        Optional<Actor> foundActorOptional = actorRepository.findById((long) actor.getActor_id());
        assertTrue(foundActorOptional.isEmpty());
    }
}