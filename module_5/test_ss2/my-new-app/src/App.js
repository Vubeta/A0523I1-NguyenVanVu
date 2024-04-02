import logo from './logo.svg';
import './App.css';

function App() {
    const students = [
        {
            id: 1, name: "haiTT", address: "QN"
        }, {
            id: 2, name: "A0520I1", address: "QN"
        }, {
            id: 3, name: "A0723I1", address: "QN"
        }
    ];

    const remove = (id) => alert("hello " + id);


  return (
      <>
          <table className="table table-hover">
              <thead>
              <tr>
                  <th scope="col">#</th>
                  <th scope="col">Name</th>
                  <th scope="col">Address</th>
                  <th scope="col">Remove</th>
              </tr>
              </thead>
              <tbody>
              {
                  students.map((student) => (
                      <tr key={student.id}>
                          <td>{student.id}</td>
                          <td>{student.name}</td>
                          <td>{student.address}</td>
                          <td><button className="btn btn-danger" onClick={() => remove(student.id)}>Xóa</button></td>
                      </tr>
                  ))
              }
              </tbody>
          </table>
      </>
  );
}

export default App;
