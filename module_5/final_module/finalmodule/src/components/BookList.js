import React, {useEffect, useState} from 'react';
import {toast} from "react-toastify";
import {useNavigate} from 'react-router-dom';
import Modal from 'react-modal';
import * as bookService from '../services/BookService';
import * as typeBooksService from '../services/TypeBooksService';

export default function BookList({customView}) {
    const [list, setList] = useState([]);
    const [typeList, setTypeList] = useState([]);
    const navigate = useNavigate();
    const [formSearch, setFormSearch] = useState({
        name: "",
        type: ""
    });

    const [modalIsOpen, setIsOpen] = useState(false);
    const [bookDelete, setBookDelete] = useState({});

    const onChangeSearch = (event) => {
        setFormSearch({...formSearch, [event.target.name]: event.target.value});
    }


    useEffect(() => {
        getList();
    }, [formSearch]);

    useEffect(() => {
        getTypeBooks();
    },[]);

    const getList = async () => {
        const temp = await bookService.getAllBook();
        const newList = temp.filter(book => book.name.toLowerCase().includes(formSearch.name.toLowerCase())
            && book.type.name.toLowerCase().includes(formSearch.type.toLowerCase()));
        setList(newList);
    }

    const getTypeBooks = async () => {
        const temp = await typeBooksService.getAllTypeBooks();
        setTypeList(temp);
    }

    const deleteBook = async () => {
        const successs = await bookService.removeBook(bookDelete.id)
        console.log(successs)
        if (successs) {
            toast.success("Deleted!");
            getList();
        }
        setIsOpen(false);
    }

    const addBook = () => {
        navigate("/book");
    }

    const updateBook = (book) => {
        navigate("/book", {state: book});
    }

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

    //confirm remove modal
    const displayModal = (book) => {
        setBookDelete(book);
        setIsOpen(true);
    }

    return (
        <div style={customView}>
            <h1>List Book:</h1>

            <div className="row g-3 needs-validation">
                <div className="col-md-6">
                    <label htmlFor="name" className="form-label">Find by name</label>
                    <input className="form-control" id="name" name="name" onChange={onChangeSearch}/>
                    <div className="invalid-feedback">
                        Please provide a valid city.
                    </div>
                </div>
                <div className="col-md-3">
                    <label htmlFor="type" className="form-label">Select book type to filter</label>
                    <select className="form-select" id="type" name="type" onChange={onChangeSearch}>
                        <option value="" selected></option>
                        {typeList && typeList.map((typeBook, index) => (
                            <option key={index} value={typeBook.name}>{typeBook.name}</option>
                        ))}
                    </select>
                    <div className="invalid-feedback">
                        Please select a valid state.
                    </div>
                </div>
            </div>

            <br/>

            <table className="table table-hover table-striped">
                <thead>
                <tr>
                    <th>Mã sách</th>
                    <th>Tên sách</th>
                    <th>Thể loại</th>
                    <th>Ngày nhập sách</th>
                    <th>Số lượng</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {
                    list.map(book => (
                        <tr key={book.id}>
                            <td>{book.bookId}</td>
                            <td>{book.name}</td>
                            <td>{book.type.name}</td>
                            <td>{book.date}</td>
                            <td>{book.count}</td>
                            <td>
                                <button
                                    style={{marginRight: '5px'}}
                                    className="btn btn-warning" onClick={() => {
                                    updateBook(book)
                                }}>Edit
                                </button>
                                <button className="btn btn-danger" onClick={() => {
                                    displayModal(book)
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
                onRequestClose={()=> {setIsOpen(false)}}
                style={customStyles}
                contentLabel="Example Modal"
            >
                <h2>Delete book</h2>

                <p>Are you sure you want to delete {bookDelete.name}?</p>
                <button onClick={deleteBook}>Delete</button>
            </Modal>

            <button className="btn btn-primary" onClick={addBook}>Create</button>
        </div>
    );


}