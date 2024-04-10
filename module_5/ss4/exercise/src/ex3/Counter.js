import React from 'react';
import useIncrement from './useIncrement';

//function Counter(props) {
//     const addMount = props.addMount;
//Ở trên là cách bình thường, bên dưới là cách sử dụng object destructuring
function Counter({addMount}) {
    const [count, setCount] = useIncrement(addMount);

    return (
        <div>
            <h2>Count: {count}</h2>
            <br/>
            <button onClick={setCount}>Add {addMount}</button>
        </div>
    );
}

export default Counter;