import logo from '../logo.svg';
import './App.css';
import {Formik} from 'formik';
import React, {useState} from "react";

function App() {

    const REGEX = {email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/};
    const [form, setForm] = useState({});

    function handleChange(event) {
        setForm({
            ...form,
            [event.target.name]: event.target.value
        });
    }

    function handleValidate(){
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

    function handleSubmit(){
        alert("Add contact successfully");
    }

    return (
        <div>
            <h1>Contact form</h1>
            <Formik
                initialValues={form}
                validate={handleValidate}
                onSubmit={handleSubmit}
            >
                {
                    ({errors, handleSubmit}) => (
                        <form onSubmit={handleSubmit}>
                            <div
                                className={`custom-input ${errors.name
                                ? "custom-input-error"
                                : ""}`}
                            >
                                <label>Name</label>
                                <input
                                    name="name"
                                    value={form.name || ""}
                                    onChange={handleChange}
                                />
                                <p className="error">{errors.name}</p>
                            </div>

                            <div
                                className={`custom-input ${errors.email
                                    ? "custom-input-error"
                                    : ""}`}
                            >
                                <label>Email</label>
                                <input
                                    name="email"
                                    value={form.email || ""}
                                    onChange={handleChange}
                                />
                                <p className="error">{errors.email}</p>
                            </div>

                            <div
                                className={`custom-input ${errors.phone
                                    ? "custom-input-error"
                                    : ""}`}
                            >
                                <label>Phone</label>
                                <input
                                    name="phone"
                                    value={form.phone || ""}
                                    onChange={handleChange}
                                />
                                <p className="error">{errors.phone}</p>
                            </div>

                            <div
                                className="custom-input">
                                <label>Message</label>
                                <input
                                    name="message"
                                    value={form.message || ""}
                                    onChange={handleChange}
                                />
                            </div>

                            <button type="submit">Submit</button>
                        </form>
                    )
                }
            </Formik>
        </div>
    );
}

export default App;
