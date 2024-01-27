import React, { useState, useEffect } from 'react';
import CardInfo from './CardInfo';
import SeatSelection from './SeatSelection';

const MovieSeance = () => {
    const [seances, setSeances] = useState([]);
    const [movies, setMovies] = useState([]);
    const [cart, setCart] = useState([]);
    const [isCartOpen, setIsCartOpen] = useState(false);
    const [isSeatSelectionOpen, setIsSeatSelectionOpen] = useState(false);
    const [selectedSeanceKey, setSelectedSeanceKey] = useState('');
    const [searchTerm, setSearchTerm] = useState('');

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
        const uniqueKey = `${selectedSeance.seance_id}_${selectedSeance.movieId}_${cart.length + 1}`;

        // Dodajemy nowy element do koszyka
        const newCartItem = { key: uniqueKey, seanceId, time: selectedSeance.time, name: selectedMovie?.name, selectedSeats: [] };
        setCart([...cart, newCartItem]);

        setSelectedSeanceKey(uniqueKey);
        setIsSeatSelectionOpen(true);
    };


    const handleToggleCart = () => {
        setIsCartOpen(!isCartOpen);
    };

    const handleCloseCartInfo = () => {
        setIsCartOpen(false);
        setIsSeatSelectionOpen(false);
    };

    const handleSeatSelected = (selectedSeats) => {
        const updatedCart = cart.map(item => {
            if (item.key === selectedSeanceKey) {
                return { ...item, selectedSeats };
            }
            return item;
        });

        setCart(updatedCart);
        setIsSeatSelectionOpen(false);
    };

    return (

        <div className="container mt-5" >
            <div className="d-flex justify-content-between align-items-center mb-4">
                <h1>Lista Seansów i Filmów</h1>
                <input
                    type="text"
                    placeholder="Szukaj filmu..."
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                />
                <div className="cart-icon" onClick={handleToggleCart} style={{ cursor: 'pointer', fontSize: '24px' }}>
                    🛒
                    {cart.length > 0 && <span className="cart-badge">{cart.length}</span>}
                </div>
            </div>
            {isCartOpen && <CardInfo cart={cart} onClose={handleCloseCartInfo} />}
            {isSeatSelectionOpen && (
                <SeatSelection
                    onSeatSelected={handleSeatSelected}
                    onCancel={handleCloseCartInfo}
                    selectedSeats={cart.find(item => item.key === selectedSeanceKey)?.selectedSeats || []}
                />
            )}
            <table className="table">
                <thead>
                <tr>
                    <th>Godzina</th>
                    <th>Film</th>
                    <th>Dodaj do koszyka</th>
                </tr>
                </thead>
                <tbody>
                {seances
                    .filter((seance) => {
                        const movieName = movies.find(movie => movie.id === seance.movieId)?.name || '';
                        return movieName.toLowerCase().includes(searchTerm.toLowerCase());
                    })
                    .map((seance) => (
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

            <iframe
                width="560"
                height="315"
                src="https://www.youtube.com/embed/8ugaeA-nMTc?si=78SQ-qQ0KZbJfuOR"
                title="YouTube video player"
                frameBorder="0"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                allowFullScreen
                style={{ marginRight: '20px' }}
            ></iframe>

            <iframe
                width="560"
                height="315"
                src="https://www.youtube.com/embed/wKtcmiifycU?si=xzkZuhLjlTq9A8Rd"
                title="YouTube video player"
                frameBorder="0"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                allowFullScreen
                style={{ marginLeft: '20px' }}
            ></iframe>
        </div>
    );
};

export default MovieSeance;
