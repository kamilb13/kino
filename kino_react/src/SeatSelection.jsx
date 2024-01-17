import React, { useState } from 'react';

const SeatSelection = ({ onSeatSelected, onCancel }) => {
    const [selectedSeats, setSelectedSeats] = useState([]);

    const handleSeatClick = (seatNumber) => {
        const isSeatSelected = selectedSeats.includes(seatNumber);

        if (isSeatSelected) {
            setSelectedSeats(selectedSeats.filter(seat => seat !== seatNumber));
        } else {
            setSelectedSeats([...selectedSeats, seatNumber]);
        }
    };

    const handleConfirm = () => {
        onSeatSelected(selectedSeats);
    };

    const renderSeat = (rowIndex, seatIndex) => {
        const seatNumber = `${rowIndex + 1}-${seatIndex + 1}`;
        const isSeatSelected = selectedSeats.includes(seatNumber);
        const seatStyle = {
            backgroundColor: isSeatSelected ? 'red' : 'green', // Kolor dla wybranych i dostępnych miejsc
            cursor: 'pointer',
            margin: '5px',
            padding: '10px',
            borderRadius: '5px',
        };

        return (
            <div
                key={seatNumber}
                style={seatStyle}
                onClick={() => handleSeatClick(seatNumber)}
            >
                {seatNumber}
            </div>
        );
    };

    // Zakładamy, że kino ma 10 rzędów i 10 miejsc w rzędzie (możesz dostosować to do swoich potrzeb)
    const rows = Array.from({ length: 10 }, (_, rowIndex) => {
        return (
            <div key={rowIndex} style={{ display: 'flex' }}>
                {Array.from({ length: 10 }, (_, seatIndex) => renderSeat(rowIndex, seatIndex))}
            </div>
        );
    });

    return (
        <div>
            <h2>Wybierz miejsca</h2>
            {rows}
            <button onClick={handleConfirm}>Potwierdź</button>
            <button onClick={onCancel}>Anuluj</button>
        </div>
    );
};

export default SeatSelection;
