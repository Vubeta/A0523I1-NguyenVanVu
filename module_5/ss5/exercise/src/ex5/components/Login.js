import {useNavigate} from "react-router-dom";
import {useState} from "react";
import {Formik} from "formik";

function Login() {
    const navigate = useNavigate();

    const [form, setForm] = useState({});
    const [accounts, setAccounts] = useState([
        {
            username: "admin@gmail.com",
            password: "letmein"
        }
    ]);

    function handleChange(event){
        setForm({
                ...form,
                [event.target.name]: event.target.value
            }
        );
    }

    function handleValidate() {
        const errors = {};

        if (!form.username) {
            errors.username = "Required";
        }

        if (!form.password) {
            errors.password = "Required";
        }

        return errors;
    }

    function handleSubmit() {
        const user = accounts.find((user) =>
            user.username === form.username && user.password === form.password);
        if (user) {
            navigate("/login", {state: form, replace: true})
        }
    }

    return (
        <>
            <h1>Login</h1>
            <Formik
                initialValues={form}
                validate={handleValidate}
                onSubmit={handleSubmit}
            >
                {({errors, handleSubmit}) => (
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label>Username</label>
                            <input
                                name="username"
                                value={form.username}
                                onChange={handleChange}
                            />
                            <p>{errors.username}</p>
                        </div>

                        <div>
                            <label>Password</label>
                            <input
                                type="password"
                                name="password"
                                value={form.password}
                                onChange={handleChange}
                            />
                            <p>{errors.password}</p>
                        </div>

                        <button type="submit">Login</button>
                    </form>
                )}
            </Formik>
        </>
    );
}

export default Login;