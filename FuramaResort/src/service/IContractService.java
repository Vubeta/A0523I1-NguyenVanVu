package model;

public interface IContractService extends Service {
    void addNewContract(Contract contract);
    void displayContracts();
}
