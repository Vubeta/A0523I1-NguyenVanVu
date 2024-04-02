import React from "react";

function Calculator(props) {
    let calculatedResult;
    const {num1, num2, operation} = props;
    switch (operation) {
        case '+':
            calculatedResult = num1 + num2;
            break;
        case '-':
            calculatedResult = num1 - num2;
            break;
        case '*':
            calculatedResult = num1 * num2;
            break;
        case '/':
            calculatedResult = num1 / num2;
            break;
        default:
            calculatedResult = 0;
    }
    return (
        <h1>Result: {calculatedResult}</h1>
    );
}

export default Calculator;