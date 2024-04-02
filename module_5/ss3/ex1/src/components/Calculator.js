import React, {useState} from "react";

function Calculator() {
    const [num1, setNum1] = useState(0);
    const [num2, setNum2] = useState(0);
    const [result, setResult] = useState(0);

    const handleNum1Change = (event) => {
        setNum1(parseInt(event.target.value));
    };

    const handleNum2Change = (event) => {
        setNum2(parseInt(event.target.value));
    };

    const handleAdd = () => {
        setResult(num1 + num2);
    };

    const handleSub = () => {
        setResult(num1 - num2);
    };

    const handleMul = () => {
        setResult(num1 * num2);
    };

    const handleDiv = () => {
        setResult(num1 / num2);
    };

    return (
        <div>
            <input type="number" value={num1} onChange={handleNum1Change}/>
            <input type="number" value={num2} onChange={handleNum2Change}/>
            <button onClick={handleAdd}>+</button>
            <button onClick={handleSub}>-</button>
            <button onClick={handleMul}>*</button>
            <button onClick={handleDiv}>/</button>
            <h2>Result: {result}</h2>
        </div>
    );
}

export default Calculator;