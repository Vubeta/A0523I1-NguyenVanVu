import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// const name = "Your name";
// const fruits = ["Apple", "Banana", "Orange", "Apricot", "Black rowan", "Cranberry"];
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    // React.createElement("h1",{style: {textAlign: "center"}}, name)

    // <h1 style={{textAlign: "center"}}>
    //     {name}
    // </h1>

    // <div>
    //     <h1>List of fruits</h1>
    //     <ul>
    //         {fruits.map((item) =>(
    //             <li>{item}</li>
    //         ))}
    //     </ul>
    // </div>

    <div>
        <h1>Hello, world!</h1>
        <h2>It is {new Date().toLocaleTimeString()}</h2>
    </div>

  // <React.StrictMode>
  //   <App />
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();