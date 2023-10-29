package model;

public interface IEmployeeService extends Service {
    void addNewEmployee(Employee employee);
    void displayEmployees();
}
