import {BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import Home from "./components/Home";
import React from "react";

function App() {
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/login" element={<Home />} />
            </Routes>
        </BrowserRouter>
    )
}

export default App;