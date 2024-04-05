import React, {useState} from 'react';

const [count, setCount] = useState(0);

function useIncrement(addAmount){
    return []
}

function increase(addAmount) {
    setCount(count + addAmount);
}

function Counter1() {
    const [count, setCount] = useIncrement(1);
}

export default Counter1;