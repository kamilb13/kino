import React, { useState } from "react";

function NewMovieForm(props) {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [date, setDate] = useState('');

    const submitMovie = (e) => {
        e.preventDefault();

        const formData = {
            name: title,
            description: description,
            premier_date: date, // Zmiana na premier_date, zgodnie z oczekiwaniami kontrolera Springa
        };

        fetch('http://localhost:8080/dodaj-film', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json',
            },
            body: JSON.stringify(formData),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                // Handle success, e.g., show a success message
                console.log('Success:', data);

                // Clear the form fields
                setDescription('');
                setTitle('');
                setDate('');
            })
            .catch(error => {
                // Handle errors, e.g., show an error message
                console.error('Error:', error);
            });
        console.log('Form Data:', formData);

    };

    return (
        <div className="mt-5">
            <form onSubmit={submitMovie}>

                    <div className="mb-3">
                        <label className="form-label">Tytuł</label>
                        <input
                            type="text"
                            className="form-control"
                            required
                            onChange={(e) => setTitle(e.target.value)}
                            value={title}
                            name="name"
                        ></input>
                    </div>
                    <div className="mb-3">
                        <label className="form-label">Description</label>
                        <textarea
                            className='form-control'
                            rows={3}
                            required
                            onChange={(e) => setDescription(e.target.value)}
                            value={description}
                            name="description"
                        ></textarea>
                    </div>
                    <div className="mb-3">
                        <label className="form-label">Description</label>
                        <input
                            type="date"
                            className='form-control'
                            rows={3}
                            required
                            onChange={(e) => setDate(e.target.value)}
                            value={date}
                            name="premier_date"
                        ></input>

                    </div>
                    <button
                        type="button"
                        className="btn btn-primary mt-3"
                        onClick={submitMovie}>
                        Add Movie
                    </button>

                <button
                    type="submit"
                    className="btn btn-primary mt-3"
                >
                    Add Movie
                </button>
            </form>
        </div>
    );
}

export default NewMovieForm;
