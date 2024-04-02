import React from "react";
import {StudentData} from "./data";

function StudentInfoComponent() {
    return (
        <div>
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Address</th>
                </tr>
                {StudentData.map((student) => {
                    return (
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.name}</td>
                            <td>{student.age}</td>
                            <td>{student.address}</td>
                        </tr>
                    );
                })}
            </table>
        </div>
    );
}

export default StudentInfoComponent;