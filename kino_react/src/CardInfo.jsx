import React from 'react';

const CartInfo = ({ cart, onClose }) => {
    console.log(cart)
    return (
        <div className="cart-info-container">
            <div className="cart-info">
                <button className="close-btn" onClick={onClose}>&times;</button>
                <h2>Twój koszyk:</h2>
                <ul>
                    {cart.map((item, index) => (
                        <li key={index}>
                            {item.time} - {item.name}
                            {item.selectedSeats.length > 0 && (
                                <div>
                                    Wybrane miejsca: {item.selectedSeats.join(', ')}
                                </div>
                            )}
                        </li>
                    ))}


                </ul>
            </div>
        </div>
    );
};

export default CartInfo;
