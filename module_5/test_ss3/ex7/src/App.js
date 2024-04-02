import logo from './logo.svg';
import './App.css';
import React, {Component} from "react";
import Home from "./components/Home";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoggedIn: false
        }
    }

    handleLogin = () => {
        this.setState({isLoggedIn: true});
    }

    handleLogout = () => {
        this.setState({isLoggedIn: false});
    }

    render() {
        const {isLoggedIn} = this.state; //tương tự với const isLoggedIn = this.state.isLoggedIn
        if (isLoggedIn) return (<Home onLogOut = {this.handleLogout} />);

        return (
            <div style={{textAlign: 'center'}}>
                <div>
                    <h1>Please Log in</h1>
                    <button onClick={this.handleLogin}>Log in</button>
                </div>
            </div>
        );
    }
}

export default App;
