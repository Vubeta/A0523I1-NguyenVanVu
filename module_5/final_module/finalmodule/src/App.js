import logo from './logo.svg';
import 'react-toastify/dist/ReactToastify.css';
import {Routes, Route} from 'react-router-dom';
import {ToastContainer} from "react-toastify";
import React from "react";
// import Header from "./components/Header";
import 'bootstrap/dist/css/bootstrap.css'
import BookList from "./components/BookList";
import Book from "./components/Book";

function App() {
    const customViewStyle = {
        margin: '1vw' // Lùi vào 1% chiều rộng của viewport
    };

    return (
        <>
            {/*<div style={customViewStyle}>*/}
            {/*    <Header />*/}
            {/*</div>*/}
            <Routes>
                <Route path="/" element={<BookList customView={customViewStyle}/>} />
                <Route path="/book" element={<Book customView={customViewStyle}/>} />
            </Routes>

            <ToastContainer/>
        </>
    );
}

export default App;
