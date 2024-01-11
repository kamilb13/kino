import React, { useState, useEffect } from 'react';

const HallList = () => {
    const [halls, setHalls] = useState([]);

    useEffect(() => {
        // Funkcja do pobierania filmów z backendu
        const fetchHalls = async () => {
            try {
                const response = await fetch('http://localhost:8080/allhalls'); // Podaj odpowiedni URL do swojego backendu
                const data = await response.json();
                //console.log(data);
                setHalls(data);
            } catch (error) {
                console.error('Błąd podczas pobierania danych:', error);
            }
        };

        fetchHalls(); // Wywołaj funkcję pobierającą dane
    }, []); // Pusta tablica oznacza, że useEffect wywoła się tylko raz po zamontowaniu komponentu

    return (
        <div>
            <h1>Lista Sal</h1>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAZWA</th>
                    <th>ILOSC MIEJSC</th>
                    <th>ILOSC WEJSC</th>
                </tr>
                </thead>
                <tbody>
                {halls.map(hall => (
                    <tr key={hall.hall_id}>
                        <td>{hall.hall_id}.</td>
                        <td>{hall.name}</td>
                        <td>{hall.seats_number}</td>
                        <td>{hall.entry_number}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default HallList;