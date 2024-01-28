import React, { useState, useEffect } from 'react';

const SeanceList = () => {
    const [seances, setSeances] = useState([]);

    useEffect(() => {
        // Funkcja do pobierania filmów z backendu
        const fetchSeances = async () => {
            try {
                const response = await fetch('http://localhost:8080/allseances');
                const data = await response.json();
                console.log(data);
                setSeances(data);
            } catch (error) {
                console.error('Błąd podczas pobierania danych:', error);
            }
        };

        fetchSeances();
    }, []);

    return (
        <div>
            <h1>Lista Seansow</h1>
            <table>
                <thead>
                <tr>
                    <th>CZAS</th>
                    <th>DateID</th>
                    <th>SalaID</th>
                    <th>MovieID</th>
                </tr>
                </thead>
                <tbody>
                {seances.map(seance => (
                    <tr key={seance.seance_id}>
                        <td>{seance.time}</td>
                        <td>{seance.dateId}</td>
                        <td>{seance.saleId}</td>
                        <td>{seance.movieId}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default SeanceList;