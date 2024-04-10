import React from 'react';
import Counter from "./Counter";

function App() {
    return (
        <div>
            <Counter addMount={1} />
            <Counter addMount={2} />
        </div>
    );
}

export default App;