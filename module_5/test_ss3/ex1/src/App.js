import logo from './logo.svg';
import './App.css';
import React, {Component} from "react";
import Welcome from "./components/Welcome";
import AddComponent from "./components/AddComponent";
import Hello from "./components/Hello";

// function App() {
//   return (
//     // <div className="App">
//     //   <header className="App-header">
//     //     <img src={logo} className="App-logo" alt="logo" />
//     //     <p>
//     //       Edit <code>src/App.js</code> and save to reload.
//     //     </p>
//     //     <a
//     //       className="App-link"
//     //       href="https://reactjs.org"
//     //       target="_blank"
//     //       rel="noopener noreferrer"
//     //     >
//     //       Learn React
//     //     </a>
//     //   </header>
//     // </div>
//       <div className="App">
//         {/*<Welcome name="Admin" />*/}
//         {/*<AddComponent firstNumber={2} secondNumber={7} />*/}
//
//       </div>
//   );
// }

class App extends Component{
    // constructor(props) {
    //     super(props);
    //     this.state = {
    //         number: 0
    //     }
    // }
    //
    // increase = () => {
    //     this.setState({number: this.state.number + 1});
    // };
    // decrease = () => {
    //     this.setState({number: this.state.number -1});
    // };
    //
    // render() {
    //     return (
    //         <div style={{textAlign: "center", padding: 30}}>
    //             <button onClick={this.decrease}>Decrease</button>
    //             <span style={{padding: 10}}>{this.state.number}</span>
    //             <button onClick={this.increase}>Increase</button>
    //         </div>
    //     );
    // }

    // constructor(props) {
    //     super(props);
    //     this.state = {
    //         color: 'black'
    //     };
    // }
    //
    // componentDidMount() {
    //     setTimeout(() => {
    //         this.setState({color: 'pink'})
    //     },5000);
    // }
    //
    // render() {
    //     return (
    //         <div>
    //             <div style={{
    //                 backgroundColor: this.state.color,
    //                 paddingTop: 20,
    //                 width: 400,
    //                 height: 80,
    //                 margin: 'auto'
    //             }}>
    //             </div>
    //         </div>
    //     );
    // }

    constructor(props) {
        super(props);
        this.state = {
            display: true
        }
    }

    delete = () => {
        this.setState({display: false});
    }

    render() {
        let comp;
        if (this.state.display) {
            comp = <Hello/>;
        }
        return (
            <div style={{textAlign: 'center'}}>
                {comp}
                <button onClick={this.delete}>Delete the component</button>
            </div>
        );
    }
}

export default App;
