import {NavLink, useLocation} from 'react-router-dom';

export default function Header() {
    const location = useLocation();

    return (
        <>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className="container-fluid">
                    <h3 className="navbar-brand">Furama Resort</h3>
                    <div className="navbar-nav flex-grow-1">
                        <NavLink className="nav-link" to="/employee" exact={true}>Employee</NavLink>
                        <NavLink className="nav-link" to="/customer" exact={true}>Customer</NavLink>
                        <NavLink className="nav-link" to="/service" exact={true}>Service</NavLink>
                    </div>
                    <div className="d-flex">
                        {location.pathname === '/service' && (
                            <NavLink className="btn btn-success" to="/service/add">Add new service</NavLink>
                        )}
                        {location.pathname === '/employee' && (
                            <NavLink className="btn btn-success" to="/employee/add">Add new employee</NavLink>
                        )}
                        {location.pathname === '/customer' && (
                            <NavLink className="btn btn-success" to="/customer/add">Add new customer</NavLink>
                        )}
                    </div>
                </div>
            </nav>
        </>
    );
}