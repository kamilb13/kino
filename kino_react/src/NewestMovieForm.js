import React, { useState } from "react";

function NewestMovieForm() {
    const [title, setTitle] = useState('');
    const [type, setType] = useState('');
    const [premiereDate, setPremiereDate] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();

        // Tutaj można wywołać odpowiednią funkcję obsługującą wysłanie danych

        // Przykładowe wywołanie API lub funkcji obsługującej zapisanie filmu
        // fetch('url_do_twojego_endpointu', {
        //     method: 'POST',
        //     headers: {
        //         'Content-Type': 'application/json',
        //     },
        //     body: JSON.stringify({ title, type, premiereDate }),
        // })
        // .then(response => response.json())
        // .then(data => {
        //     // Obsługa odpowiedzi z serwera
        // })
        // .catch(error => {
        //     // Obsługa błędu
        // });

        // Po obsłudze wysłania danych można zresetować stan formularza
        setTitle('');
        setType('');
        setPremiereDate('');
    };

    return (
        <form onSubmit={handleSubmit}>
            <label htmlFor="title">Tytuł:</label>
            <input
                type="text"
                id="title"
                name="title"
                required
                value={title}
                onChange={(e) => setTitle(e.target.value)}
            />

            <label htmlFor="type">Typ:</label>
            <input
                type="text"
                id="type"
                name="type"
                required
                value={type}
                onChange={(e) => setType(e.target.value)}
            />

            <label htmlFor="premiereDate">Data premiery filmu:</label>
            <input
                type="date"
                id="premiereDate"
                name="premiereDate"
                required
                value={premiereDate}
                onChange={(e) => setPremiereDate(e.target.value)}
            />

            <button type="submit">Dodaj Film</button>
        </form>
    );
}

export default NewestMovieForm;
