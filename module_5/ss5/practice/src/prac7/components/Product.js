import React from 'react';
import {useLocation} from 'react-router-dom';

function Product() {
    const {state} = useLocation();

    return (
        <div>
            <h2>Id selected {state.categoryId}</h2>
        </div>
    );
}

export default Product;