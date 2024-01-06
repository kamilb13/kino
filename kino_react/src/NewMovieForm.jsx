import React, { useState } from "react";

function NewMovieForm(props) {


    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [date, setDate] = useState('');

    const submitMovie = () => {


        const formData = {
            name: title,
            description: description,
            premier_date: date,
        };

        setDescription('');
        setTitle('');
        setDate('');

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
            }).then(data => {
            console.log('Success:', data);



        })
            .catch(error => {
                console.error('Error:', error);
            });

        window.location.reload();


        document.addEventListener("DOMContentLoaded", function() {
            // Po załadowaniu strony
            window.location.href = window.location.href + '#sectionID';
        });

    };

    return (
        <div className="mt-5">
            <form onSubmit={submitMovie} id="Form">

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
