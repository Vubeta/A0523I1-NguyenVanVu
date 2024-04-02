import logo from './logo.svg';
import './App.css';
import React, {useState} from "react";
import Calculator from "../../ex2/src/Calculator";

function App() {
    const [num1, setNum1] = useState(0);
    const [num2, setNum2] = useState(0);
    const [operation, setOperation] = useState('+');

    const handleNum1Change = (event) => {
        setNum1(parseInt(event.target.value));
    };

    const handleNum2Change = (event) => {
        setNum2(parseInt(event.target.value));
    };

    const handleOperationChange = (event) => {
        setOperation(event.target.value);
    };

    return (
        <>
            <input type="number" onChange={handleNum1Change}/>
            <br/>
            <input type="number" onChange={handleNum2Change}/>
            <Calculator num1={num1} num2={num2} operation={operation}/>
            <button value="+" onClick={handleOperationChange}>+</button>
            <button value="-" onClick={handleOperationChange}>-</button>
            <button value="*" onClick={handleOperationChange}>x</button>
            <button value="/" onClick={handleOperationChange}>/</button>
        </>
    );
}

export default App;