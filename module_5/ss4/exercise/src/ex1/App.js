import logo from '../logo.svg';
import '../App.css';
import React, {useState} from "react";

function App() {
    const [cars, setCars] = useState([
        "Pagani Huayra Imola ",
        "Bugatti Divo",
        "SP Automotive Chaos",
        "Pagani Codalunga",
        "Maybach",
        "Bugatti Centodieci",
        "Bugatti Chiron Profilée",
        "Rolls-royce Sweptail",
        "Bugatti La Voiture Noire",
        "Rolls-Royce Boat Tail"
    ]);
    const [colors, setColors] = useState([
        "Red",
        "Black",
        "Silver",
        "Blue",
        "Orange",
        "Pink"
    ]);
    const [selectedCar, setSelectedCar] = useState({
        car: cars[0],
        color: colors[0]
    });

    const handleChangeSelection = (e) => {
        const {name, value} = e.target;
        const {car, color} = selectedCar;

        name === "car"
            ? setSelectedCar({car: value, color: color})
            : setSelectedCar({car: car, color: value})
    }
    return (
        <div>
            <h1>Select your car</h1>
            <label>Select a car</label>
            <select name="car" onChange={handleChangeSelection}>
                {cars.map((car,index) => (
                    <option key={index} value={cars[index]}>{car}</option>
                ))}
            </select>
            <br/>
            <label>Select a color</label>
            <select name="color" onChange={handleChangeSelection}>
                {colors.map((color,index) => (
                    <option key={index} value={colors[index]}>{color}</option>
                ))}
            </select>
            <h2>You selected a {selectedCar.color + " - " + selectedCar.car}</h2>
        </div>
    );
}

export default App;
