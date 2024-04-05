import React from 'react';
import {useEffect, useState} from "react";

function App() {
    const [time, setTime] = useState(10);

    useEffect(() => {
        const timeDown = setInterval(() => {
            setTime((count) => count - 1)
        }, 1000);

        return () => clearInterval(timeDown);
    }, []);

    useEffect(() => {
            if (time === 0) {
                alert("Time's up");
                setTime(10);
            }
        }
    )

    return (
        <div>
            <h2>Count down from {time}</h2>
        </div>
    );
}

export default App;