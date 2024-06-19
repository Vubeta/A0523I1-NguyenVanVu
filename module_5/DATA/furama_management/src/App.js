import logo from './logo.svg';
import './App.css';
import Header from "./components/Header";
import {Routes, Route} from 'react-router-dom';
import EmployeeList from "./components/employee/EmployeeList";
import CustomerList from "./components/customer/CustomerList";
import ServiceList from "./components/service/ServiceList";
import React from "react";
import CreateService from "./components/service/CreateService";

function App() {
    const customViewStyle = {
        margin: '1vw' // Lùi vào 1% chiều rộng của viewport
    };
    return (
        <>
            <div style={customViewStyle}>
                <Header />
            </div>
            <Routes>
                <Route path="/employee" element={<EmployeeList />} />

                <Route path="/customer" element={<CustomerList />} />

                <Route path="/service" element={<ServiceList customView={customViewStyle} />} />
                <Route path="/service/add" element={<CreateService customView={customViewStyle} />} />

            </Routes>
        </>
    );
}

export default App;
