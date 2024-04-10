import {useNavigate} from "react-router-dom";
import React from 'react';

function Category() {
    const navigate = useNavigate();

    const handleChangeSelection = (event) => {
        navigate(`product/${event.target.value}`);
    };

    return (
        <div>
            <h2>Select a Category:</h2>
            <select
                defaultValue="default"
                onChange={(e) => handleChangeSelection(e)}
            >
                <option value="default" disable hidden>
                    Choose your car
                </option>
                <option value="1">Honda</option>
                <option value="2">Suzuki</option>
                <option value="3">Yamaha</option>
            </select>
        </div>
    );
}

export default Category;