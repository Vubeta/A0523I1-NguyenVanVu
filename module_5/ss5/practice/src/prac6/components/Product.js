import {useParams} from 'react-router-dom';
import React from 'react';

function Product(){
const {categoryId} = useParams();
    return (
        <h2>In selected {categoryId}</h2>
    );
}

export default Product;