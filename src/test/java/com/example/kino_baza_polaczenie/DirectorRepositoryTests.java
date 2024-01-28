package com.example.kino_baza_polaczenie;

import com.example.kino_baza_polaczenie.model.Director;
import com.example.kino_baza_polaczenie.repository.DirectorRepository;
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
public class DirectorRepositoryTests {

    @Autowired
    private DirectorRepository directorRepository;

    @Test
    public void testSaveDirector() {
        Director director = new Director("Jan", "Bednarek", LocalDate.of(1970, 3, 15));
        Director savedDirector = directorRepository.save(director);
        assertEquals(director, savedDirector);
    }

    @Test
    public void testFindAllDirectors() {
        List<Director> directors = directorRepository.findAll();
        assertNotEquals(0, directors.size());
    }

    @Test
    public void testFindDirectorById() {
        Director director = new Director("Szymon", "Kowalski", LocalDate.of(1985, 2, 11));
        directorRepository.save(director);
        Optional<Director> foundDirectorOptional = directorRepository.findById((long) director.getDirector_id());
        assertTrue(foundDirectorOptional.isPresent());
        assertEquals(director, foundDirectorOptional.get());
    }

    @Test
    public void testDeleteDirector() {
        Director director = new Director("Marisuz", "Kałamarnica", LocalDate.of(1956, 11, 7));
        directorRepository.save(director);
        directorRepository.delete(director);
        Optional<Director> foundDirectorOptional = directorRepository.findById((long) director.getDirector_id());
        assertTrue(foundDirectorOptional.isEmpty());
    }
}