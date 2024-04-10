import {useState} from "react";

function useIncrement(addAmount) {
    const [count, setCount] = useState(0);

    function increase() {
        setCount(count + addAmount)
    }

    return [count, increase];
}

export default useIncrement;