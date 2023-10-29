package model;

public interface ICustomerService extends Service {
    void addNewCustomer(Customer customer);
    void displayCustomers();
}
