import './App.css';
import React, {useState} from 'react';
import {Formik} from 'formik';

function App() {
    const REGEX = {
        email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
    };

    const [form, setForm] = useState({});

    function handleChange(event) {
        setForm({
            ...form,
            [event.target.name]: event.target.value
        });
    }

    function handleValidate() {
        const errors = {};
        if (!form.name) {
            errors.name = "Required";
        }

        if (!form.email) {
            errors.email = "Required";
        } else if (!REGEX.email.test(form.email)) {
            errors.email = "Invalid email address";
        }

        if (!form.phone) {
            errors.phone = "Required";
        }

        return errors;
    }

    function handleSubmit() {
        alert("Add contact successfully!!!")
    }

    return (
        <>
            <h2>Contact form</h2>
            <Formik
                initialValues = {form}
                validate = {handleValidate}
                onSubmit = {handleSubmit}
            >
                {({errors, handleSubmit}) => (
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label>Name</label>
                            <input
                                className={`custom-input ${errors.name?"custom-input-error":""}`}
                                name = "name"
                                value={form.name || ""}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.name}</p>
                        </div>

                        <div>
                            <label>Email</label>
                            <input
                                className={`custom-input ${errors.email?"custom-input-error":""}`}
                                name = "email"
                                value={form.email || ""}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.email}</p>
                        </div>

                        <div>
                            <label>Phone</label>
                            <input
                                className={`custom-input ${errors.phone?"custom-input-error":""}`}
                                name = "phone"
                                value={form.phone || ""}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.phone}</p>
                        </div>

                        <div>
                            <label>Message</label>
                            <input
                                className={"custom-input"}
                                name = "message"
                                value={form.message || ""}
                                onChange={handleChange}
                            />
                        </div>

                        <button type='submit'>Submit</button>
                    </form>
                )}
            </Formik>
        </>
    );
}

export default App;