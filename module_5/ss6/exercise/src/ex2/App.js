import React from 'react';
import {Routes, Route} from 'react-router-dom';
import BookList from "./components/BookList";
import AddBook from "./components/AddBook";
import UpdateBook from "./components/UpdateBook";

function App() {
    return (
        <div>
            <Routes>
                <Route path="/" element={<BookList/>}/>
                <Route path="/book/add" element={<AddBook/>}/>
                <Route path={"/book/update/:bookId"} element={<UpdateBook/>}/>
            </Routes>
        </div>
    );
}

export default App;