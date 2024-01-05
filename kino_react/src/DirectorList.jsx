import React, { useState, useEffect } from 'react';

const DirectorList = () => {
    const [directors, setDirectors] = useState([]);

    useEffect(() => {
        // Funkcja do pobierania filmów z backendu
        const fetchDirectors = async () => {
            try {
                const response = await fetch('http://localhost:8080/alldirectors'); // Podaj odpowiedni URL do swojego backendu
                const data = await response.json();
                //console.log(data);
                setDirectors(data);
            } catch (error) {
                console.error('Błąd podczas pobierania danych:', error);
            }
        };

        fetchDirectors(); // Wywołaj funkcję pobierającą dane
    }, []); // Pusta tablica oznacza, że useEffect wywoła się tylko raz po zamontowaniu komponentu

    return (
        <div>
            <h1>Lista Reżyserów</h1>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Imie</th>
                    <th>Nazwisko</th>
                </tr>
                </thead>
                <tbody>
                {directors.map(director => (
                    <tr key={director.director_id}>
                        <td>{director.director_id}.</td>
                        <td>{director.name}</td>
                        <td>{director.lastName}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default DirectorList;
