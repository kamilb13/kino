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
                            {item.time.substring(0, 5)} - {item.name}
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default CartInfo;
