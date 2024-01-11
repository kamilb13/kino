import React, { useState } from "react";

function NewSeanceForm(props) {


    const [time, setTime] = useState('');
    const [dateId, setDateId] = useState('');
    const [saleId, setSaleId] = useState('');
    const [movieId, setMovieId] = useState('');

    const submitMovie = () => {


        const formData = {
            time: time,
            dateId: dateId,
            saleId: saleId,
            movieId: movieId,
        };

        setTime('');
        setDateId('');
        setSaleId('');
        setMovieId('');

        fetch('http://localhost:8080/dodaj-seans', {
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

    };

    return (
        <div className="mt-5">
            <form onSubmit={submitMovie} id="Form">

                <div className="mb-3">
                    <label className="form-label">Time</label>
                    <input
                        type="time"
                        className="form-control"
                        required
                        onChange={(e) => setTime(e.target.value)}
                        value={time}
                        name="time"
                    ></input>
                </div>
                <div className="mb-3">
                    <label className="form-label">DateID</label>
                    <input
                        type="date"
                        className='form-control'
                        rows={3}
                        required
                        onChange={(e) => setDateId(e.target.value)}
                        value={dateId}
                        name="dateId"
                    ></input>
                </div>
                <div className="mb-3">
                    <label className="form-label">SaleID</label>
                    <input
                        type="number"
                        className='form-control'
                        rows={3}
                        required
                        onChange={(e) => setSaleId(e.target.value)}
                        value={saleId}
                        name="saleId"
                    ></input>

                </div>
                <div className="mb-3">
                    <label className="form-label">MovieID</label>
                    <input
                        type="number"
                        className='form-control'
                        rows={3}
                        required
                        onChange={(e) => setMovieId(e.target.value)}
                        value={movieId}
                        name="movieId"
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

export default NewSeanceForm;
