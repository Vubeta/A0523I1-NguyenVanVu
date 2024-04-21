import {useEffect, useState} from "react";
import {NotificationContainer, NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';
import {useNavigate, useParams} from 'react-router-dom';
import * as bookService from "../services/BookService";

function UpdateBook() {
    const navigate = useNavigate();
    const {bookId} = useParams();
    const [book, setBook] = useState({});
    let notificationTimeoutId;

    const handleChange = (event) => {
        if (event.target.name === "title") {
            setBook({...book, title: event.target.value});
        } else if (event.target.name === "quantity") {
            setBook({...book, quantity: parseInt(event.target.value)});
        }
    }

    const updateBook = async (event) => {
        event.preventDefault();
        console.log(book)
        const isSuccess = await bookService.updateBook(bookId, book);

        if (isSuccess) {
            setBook({});
            console.log('Book updated successfully');
            NotificationManager.success('Book updated successfully', 'Success', 3000);
            notificationTimeoutId = setTimeout(() => navigate('/'),3000);
        }
    }

    useEffect(() => {
        //code run when component mount
        getBook();
        return () => {
            //code run when component unmount
            clearTimeout(notificationTimeoutId);
        };
    }, []);

    const getBook = async () => {
        const result = await bookService.findById(bookId);
        setBook(result);
    };

    return (
        <div>
            <h2>Edit</h2>
            <br/>
            <br/>
            <form onSubmit={updateBook}>
                <div>
                    <label>Title</label>
                    <br/>
                    <input
                        name = "title"
                        value={book.title}
                        onChange={handleChange}
                    />
                </div>

                <div>
                    <label>Quantity</label>
                    <br/>
                    <input
                        type="number"
                        name = "quantity"
                        value={book.quantity}
                        onChange={handleChange}
                    />
                </div>

                <button type="submit">Save</button>
            </form>

            <NotificationContainer/>
        </div>
    );
}

export default UpdateBook;