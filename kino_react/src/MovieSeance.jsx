import React, { useState, useEffect } from 'react';
import CardInfo from './CardInfo';

const MovieSeance = () => {
    const [seances, setSeances] = useState([]);
    const [movies, setMovies] = useState([]);
    const [cart, setCart] = useState([]);
    const [isCartOpen, setIsCartOpen] = useState(false);

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
        const selectedSeance = seances.find(seance => seance.seance_id === seanceId);
        const selectedMovie = movies.find(movie => movie.id === selectedSeance.movieId);
        console.log("Selected Seance:", selectedSeance);
        console.log("Selected Movie:", selectedMovie);
        setCart([...cart, { time: selectedSeance.time, name: selectedMovie?.name }]);
        console.log(`Dodano do koszyka seans o ID: ${seanceId}`);
    };

    const handleToggleCart = () => {
        setIsCartOpen(!isCartOpen);
    };

    const handleCloseCartInfo = () => {
        setIsCartOpen(false);
    };

    console.log('Movies:', movies);
    console.log('Seances:', seances);
    console.log('Cart:', cart);

    return (
        <div className="container mt-5">
            <div className="d-flex justify-content-between align-items-center mb-4">
                <h1>Lista Seansów i Filmów</h1>
                <div className="cart-icon" onClick={handleToggleCart} style={{ cursor: 'pointer', fontSize: '24px' }}>
                    🛒
                    {cart.length > 0 && <span className="cart-badge">{cart.length}</span>}
                </div>
            </div>
            {isCartOpen && <CardInfo cart={cart} onClose={handleCloseCartInfo} />}
            <table className="table">
                <thead>
                <tr>
                    <th>Godzina</th>
                    <th>Film</th>
                    <th>Dodaj do koszyka</th>
                </tr>
                </thead>
                <tbody>
                {seances.map((seance) => (
                    <tr key={seance.seance_id}>
                        <td>{seance.time.substring(0, 5)}</td>
                        <td>
                            <strong>Nazwa filmu:</strong> {movies.find(movie => movie.id === seance.movieId)?.name}
                            <br />
                            <strong>Rok produkcji:</strong> {movies.find(movie => movie.id === seance.movieId)?.premier_date.split('-')[0]}
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
