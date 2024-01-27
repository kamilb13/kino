import React from 'react';
import AdminPanel from './AdminPanel';
import MainPage from './MainPage';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<MainPage />} />
                <Route path="/AdminPanel" element={<AdminPanel />} />
            </Routes>
        </Router>
    );
};

export default App;
