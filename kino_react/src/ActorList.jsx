import React, { useState, useEffect } from 'react';

const ActorList = () => {
    const [actors, setActors] = useState([]);

    useEffect(() => {
        // Funkcja do pobierania filmów z backendu
        const fetchActors = async () => {
            try {
                const response = await fetch('http://localhost:8080/allActors'); // Podaj odpowiedni URL do swojego backendu
                const data = await response.json();
                //console.log(data);
                setActors(data);
            } catch (error) {
                console.error('Błąd podczas pobierania danych:', error);
            }
        };

        fetchActors(); // Wywołaj funkcję pobierającą dane
    }, []); // Pusta tablica oznacza, że useEffect wywoła się tylko raz po zamontowaniu komponentu

    return (
        <div>
            <h1>Lista aktorów</h1>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Imie</th>
                    <th>Nazwisko</th>
                    <th>Wynagrodzenie</th>
                </tr>
                </thead>
                <tbody>
                {actors.map(actor => (
                    <tr key={actor.actor_id}>
                        <td>{actor.actor_id}.</td>
                        <td>{actor.name}</td>
                        <td>{actor.lastName}</td>
                        <td>{actor.salary}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ActorList;
