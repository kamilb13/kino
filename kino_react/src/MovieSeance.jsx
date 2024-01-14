import React, { useState, useEffect } from 'react';

const MovieSeance = () => {
    const [seances, setSeances] = useState([]);
    const [movies, setMovies] = useState([]);

    useEffect(() => {
        const fetchSeances = async () => {
            try {
                const response = await fetch('http://localhost:8080/allseances');
                const data = await response.json();
                setSeances(data);
            } catch (error) {
                console.error('Błąd podczas pobierania danych seansów:', error);
            }
        };

        const fetchMovies = async () => {
            try {
                const response = await fetch('http://localhost:8080/filmy');
                const data = await response.json();
                setMovies(data);
            } catch (error) {
                console.error('Błąd podczas pobierania danych filmów:', error);
            }
        };

        fetchSeances();
        fetchMovies();
    }, []);

    const handleAddToCart = (seanceId) => {
        console.log(`Dodano do koszyka seans o ID: ${seanceId}`);
        // logika koszyka
    };

    return (
        <div className="container mt-5">
            <h1>Lista Seansów i Filmów</h1>
            <table className="table">
                <thead>
                <tr>
                    <th>Czas</th>
                    <th>Film</th>
                    <th>Dodaj do koszyka</th>
                </tr>
                </thead>
                <tbody>
                {seances.map((seance) => (
                    <tr key={seance.seance_id}>
                        <td>{seance.time}</td>
                        <td>
                            <strong>Nazwa filmu:</strong> {movies.find(movie => movie.id === seance.movieId)?.name}
                            <br />
                            <strong>Rok produkcji:</strong> {movies.find(movie => movie.id === seance.movieId)?.dateId}
                        </td>
                        <td>
                            <button onClick={() => handleAddToCart(seance.seance_id)}>
                                Dodaj do koszyka
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default MovieSeance;
