import React from 'react';
import Users from "./pages/Users";
import UserDetails from "./pages/UserDetails";
import {BrowserRouter, Routes, Route} from "react-router-dom";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Users/>}/>
                <Route path="/user/add" element={<UserDetails/>}/>
                <Route path="/user/:userId" element={<UserDetails/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;