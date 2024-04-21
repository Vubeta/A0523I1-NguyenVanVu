import {useEffect, useState} from 'react';
import {useNavigate} from 'react-router-dom';
import * as bookService from "../services/BookService";
import Modal from 'react-modal';
import {toast} from "react-toastify";

function BookList() {
    const navigate = useNavigate();
    const [books, setBooks] = useState([]);
    const [titleSearch, setTitleSearch] = useState("");
    const [modalIsOpen, setIsOpen] = useState(false);
    const [bookSelected, setBookSelected] = useState({});

    const customStyles = {
        content: {
            top: '30%',
            left: '50%',
            right: 'auto',
            bottom: 'auto',
            marginRight: '-50%',
            transform: 'translate(-50%, -50%)',
        },
    };

    useEffect(() => {
        getAll();
    }, []);

    //show bookList
    const getAll = async () => {
        const temp = await bookService.getAllBook();
        const result = temp.filter(book => book.title.includes(titleSearch));
        setBooks(result);
    };

    //remove book by id
    const removeBook = async () => {
        const isSuccess = await bookService.removeBook(bookSelected.id);
        if (isSuccess) {
            toast.success("Your changes have been successfully saved");
        }
        setIsOpen(false);
        getAll();
    }

    //confirm delete modal
    const openModal = (book) => {
        setBookSelected(book);
        setIsOpen(true);
    }

    //add book
    const handleCreate = () => {
        navigate('/book/add');
    }

    //edit book
    const handleUpdate = (bookId) => {
        navigate(`/book/update/${bookId}`);
    }

    return (
        <div>
            <nav className="navbar navbar-expand-lg bg-light">
                <div className="container-fluid">
                    <h4>Library</h4>

                    <div className="d-flex">
                        <button
                            className="btn btn-success"
                            onClick={handleCreate}
                        >
                            Add a new Book
                        </button>
                    </div>
                </div>
            </nav>

            <table className="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Title</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                {books.map((book) => (
                    <tr key={book.id}>
                        <td>{book.title}</td>
                        <td>{book.quantity}</td>
                        <td>
                            <button className="btn btn-primary" onClick={() => {
                                handleUpdate(book.id)
                            }}>Edit
                            </button>
                            <span style={{marginRight: '10px'}}></span>
                            <button className="btn btn-danger" onClick={() => {
                                openModal(book)
                            }}>Delete
                            </button>
                        </td>
                    </tr>
                ))
                }
                </tbody>
            </table>

            <Modal
                isOpen={modalIsOpen}
                // onAfterOpen={afterOpenModal}
                onRequestClose={() => setIsOpen(false)}
                style={customStyles}
                contentLabel="Example Modal"
            >
                <h2>Delete book</h2>

                <p>Are you sure you want to delete {bookSelected.title}?</p>
                <button onClick={removeBook}>Delete</button>
            </Modal>
        </div>
    );
}

export default BookList;