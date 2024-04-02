import {Component} from "react";
import './App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {studentList: [],
            form: {name: '', phone: '', email: ''},
            isValid: false,
            indexSelected: -1
        }
    }

    handleChange = (event) => {
        this.setState((state) => {
            const form = state.form;
            form[event.target.name] = event.target.value;
            return {form};
        }, () => this.checkInvalidForm())
    }

    handleSelect = (studentSelected, index) => {
        this.setState({
            //JSON.stringify(studentSelected) chuyển đổi đối tượng studentSelected thành một chuỗi JSON
            //JSON.parse() chuyển đổi chuỗi JSON thành một đối tượng Javascript mới
            //Điều này giúp ta tạo ra một bản sao độc lập của đối tượng studentSelected và không thay đổi trực tiếp nó
            //Kết quả cuối cùng của đối tượng form trong state sẽ chứa các chứa các thuộc tính giống hệt studentSelected, nhưng là một bản sao độc lập
            form: JSON.parse(JSON.stringify(studentSelected)),
            indexSelected: index
        })
    }

    checkInvalidForm = () => {
        const {name, phone, email} = this.state.form;
        const value = name && phone && email;
        this.setState({isValid: value});
    }

    handleSubmit = () => {
        if (this.state.isValid) {
            const newList = [...this.state.studentList];
            if (this.state.indexSelected > -1) {
                //Thay thế giá trị this.state.form vào vị trí indexSelected trong newList
                newList.splice(this.state.indexSelected, 1, this.state.form);
                this.setState({
                    form: {
                        name: "",
                        phone: "",
                        email: ""
                    },
                    indexSelected: -1
                });
            } else {
                //Thêm giá trị this.state.form vào cuối mảng newList
                newList.push(this.state.form);
                this.setState({
                    form: {
                        name: "",
                        phone: "",
                        email: ""
                    }
                });
            }
            this.setState({studentList: newList});
        }
    }

    handleDelete = (index) => {
        const newList = [...this.state.studentList];
        newList.splice(index, 1);
        this.setState({studentList: newList})
    }

    render() {
        return (
            <div>
                <div>
                    <h1>Student List</h1>
                    <div>
                        <label>Name: </label>
                        <input name="name" value={this.state.form.name} onChange={this.handleChange} />
                    </div>
                    <div>
                        <label>Phone: </label>
                        <input type="number" name="phone" value={this.state.form.phone} onChange={this.handleChange} />
                    </div>
                    <div>
                        <label>Email: </label>
                        <input name="email" value={this.state.form.email} onChange={this.handleChange} />
                    </div>
                    <button onClick={this.handleSubmit}>Submit</button>
                    <table>
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        {this.state.studentList.map((student, index) => (
                            <tr key={index}>
                                <td>{student.name}</td>
                                <td>{student.phone}</td>
                                <td>{student.email}</td>
                                <td>
                                    <button onClick={() => this.handleSelect(student, index)}>Edit</button>
                                    <button onClick={() => this.handleDelete(index)}>Delete</button>
                                </td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default App;