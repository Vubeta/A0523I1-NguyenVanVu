import React, {useState} from 'react';

function App() {
    const [count, setCount] = useState(0);

    function useIncrement(addAmount){

    }

    function increase(addAmount) {
        setCount(count + addAmount);
    }

}

export default App;