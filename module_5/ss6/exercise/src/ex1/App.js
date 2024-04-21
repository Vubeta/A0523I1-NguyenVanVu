import logo from '../logo.svg';
import './App.css';
import React, {useState, useEffect} from 'react';
import axios from 'axios';

function App() {
    const [todos, setTodos] = useState([]);
    const [newTodo, setNewTodo] = useState('');

    useEffect(() => {
        fetchTodos();
    }, []);

    const fetchTodos = async () => {
        try {
            const response = await axios.get('http://localhost:8080/posts');
            setTodos(response.data);
        } catch (error) {
            console.error('Error fetching todos:', error);
        }
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        axios.post('http://localhost:8080/posts', {title: newTodo})
            .then(response => {
                alert(`Response status: ${response.status}`);
                setNewTodo('');
                return fetchTodos();
            })
            .catch(error => {
                console.error('Error adding todo:', error);
            });
    };

    return (
        <div>
            <h1>Todo List</h1>
            <form onSubmit={handleSubmit}>
                <input
                    value={newTodo}
                    onChange={(e) => setNewTodo(e.target.value)}
                    placeholder="Enter todo task"
                />
                <button type="submit">Submit</button>
            </form>
            <ul>
                {todos.map((todo) => (
                    <li key={todo.id}>{todo.title}</li>
                ))}
            </ul>
        </div>
    );
}

export default App;