import {useNavigate, useLocation} from "react-router-dom";
import Employees from "./EmployeeList";
import React, {useState} from "react";

function Employee() {
    const {state} = useLocation();
    const navigate = useNavigate();

    function handleDetail(employee) {
        navigate("/employee/detail", {state: employee, replace: true});
    }

    return (
        <div>
            <h1>Account {state.username} login successfully!!!</h1>
            <h2>Employees</h2>
            <table>
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Employee name</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {Employees.map((employee, index) => (
                    <tr key={index}>
                        <td>{index + 1}</td>
                        <td>{employee.name}</td>
                        <td>
                            <button onClick={() => {handleDetail(employee)}}>
                                Detail
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default Employee;