import logo from './logo.svg';
import './App.css';
import React, {Component} from "react";
import {Text} from "./data";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {isExpand: false};
    }

    handleExpand = () => {
        this.state.isExpand ? this.setState({isExpand: false}) : this.setState({isExpand: true});
    }

    render() {
        return (
            <>
                <div className="hd-cus">
                    <h1 className="ht-cus">Conditional Rendering</h1>
                </div>
                {this.state.isExpand ? (
                    <div>
                        <button onClick={this.handleExpand}>
                            Đóng giới thiệu
                        </button>
                        <br/>
                        <h4>Giới thiệu</h4>
                        <span>{Text}</span>
                    </div>
                ) : (
                    <button onClick={this.handleExpand}>
                        Xem giới thiệu
                    </button>
                )}
            </>
        );
    }

}

export default App;
