import {useEffect, useState} from "react";
import {NotificationContainer, NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';
import {useNavigate} from 'react-router-dom';
import * as bookService from "../services/BookService";

function AddBook() {
    const navigate = useNavigate();
    const [book, setBook] = useState({});
    let notificationTimeoutId;

    const handleChange = (event) => {
        if (event.target.name === "title") {
            setBook({...book, title: event.target.value});
        } else if (event.target.name === "quantity") {
            setBook({...book, quantity: parseInt(event.target.value)});
        }
    }

    const createBook = async (event) => {
        event.preventDefault();
        const isSuccess = await bookService.addNewBook(book);

        if (isSuccess) {
            setBook({});
            console.log('Book added successfully');
            NotificationManager.success('Book added successfully', 'Success', 3000);
            notificationTimeoutId = setTimeout(() => navigate('/'),3000);
        }
    }

    useEffect(() => {
        //code run when component mount
        return () => {
            //code run when component unmount
            clearTimeout(notificationTimeoutId);
        };
    }, []);

    return (
        <div>
            <h2>Add a new Book</h2>
            <br/>
            <br/>
            <form onSubmit={createBook}>
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

                <button type="submit">Add</button>
            </form>

            <NotificationContainer/>
        </div>
    );
}

export default AddBook;