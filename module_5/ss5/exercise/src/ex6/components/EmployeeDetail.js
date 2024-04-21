import {useLocation} from "react-router-dom";
import React from "react";

function EmployeeDetail() {
    const {state} = useLocation();

    return(
        <div>
            <p>Employee id: {state.id}</p>
            <p>Employee name: {state.name}</p>
            <p>Employee age: {state.age}</p>
        </div>
    );
}

export default EmployeeDetail;