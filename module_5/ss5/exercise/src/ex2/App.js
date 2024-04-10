import {Formik} from 'formik';
import React, {useState} from 'react';
import "./App.css";

function App() {
    const [books, setBooks] = useState([]);
    const [form, setForm] = useState({});
    const [indexSelected, setIndexSelected] = useState(-1);

    function handleChange(event) {
        setForm({
            ...form,
            [event.target.name]: event.target.value
        });
    }

    function handleValidate() {
        const errors = {};

        if (!form.title) {
            errors.title = "Required";
        }

        if (!form.number) {
            errors.number = "Required";
        }

        return errors;
    }

    function handleSelect(book, index) {
        setForm(book);
        setIndexSelected(index);
    }

    function handleDelete(index) {
        const newBooks = JSON.parse(JSON.stringify(books));
        newBooks.splice(index, 1);
        setBooks(newBooks);
    }

    function handleSubmit() {
        const newBooks = JSON.parse(JSON.stringify(books));
        if (indexSelected > -1) {
            newBooks.splice(indexSelected, 1, form)
        } else {
            newBooks.push(form)
        }

        setBooks(newBooks);
        setForm({});
        setIndexSelected(-1);
    }

    return (
        <div>
            <h2>Library</h2>
            <Formik
                initialValues={form}
                validate={handleValidate}
                onSubmit={handleSubmit}
            >
                {({errors, handleSubmit}) => (
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label>Tiêu đề</label>
                            <input
                                className={`custom-input ${errors.title
                                    ? "custom-input-error"
                                    : ""}`}
                                name="title"
                                value={form.title || ""}
                                onChange={handleChange}
                            />
                            <p className="error">{errors.title}</p>
                        </div>

                        <div>
                            <label>Số lượng</label>
                            <input
                                className={`custom-input ${errors.number
                                    ? "custom-input-error"
                                    : ""}`}
                                type="number"
                                name="number"
                                value={form.number || ""}
                                onChange={handleChange}
                            />
                            <p className="error">{errors.number}</p>
                        </div>

                        <button type="submit">Submit</button>
                    </form>
                )}
            </Formik>

            <table>
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Number</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {books.map((book, index) => (
                    <tr key={index}>
                        <td>{book.title}</td>
                        <td>{book.number}</td>
                        <td>
                            <button onClick={() => {
                                handleSelect(book, index)
                            }}>Edit
                            </button>
                            <button onClick={() => {
                                handleDelete(index)
                            }}>Delete
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default App;