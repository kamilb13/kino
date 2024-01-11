import React, { useState, useEffect } from 'react';

const MovieList = () => {
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        // Funkcja do pobierania filmów z backendu
        const fetchMovies = async () => {
            try {
                const response = await fetch('http://localhost:8080/filmy'); // Podaj odpowiedni URL do swojego backendu
                const data = await response.json();
                //console.log(data);
                setMovies(data);
            } catch (error) {
                console.error('Błąd podczas pobierania danych:', error);
            }
        };

        fetchMovies(); // Wywołaj funkcję pobierającą dane
    }, []); // Pusta tablica oznacza, że useEffect wywoła się tylko raz po zamontowaniu komponentu

    return (
        <div className="container d-flex justify-content-center">
            <div>
                <h1>Lista filmów</h1>
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nazwa</th>
                    </tr>
                    </thead>
                    <tbody>
                    {movies.map(movie => (
                        <tr key={movie.id}>
                            <td>{movie.id}.</td>
                            <td>{movie.name}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default MovieList;
