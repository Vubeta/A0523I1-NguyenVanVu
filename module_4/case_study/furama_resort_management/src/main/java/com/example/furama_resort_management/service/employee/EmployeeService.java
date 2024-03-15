package com.example.furama_resort_management.service.employee;

import com.example.furama_resort_management.model.employee.Employee;
import com.example.furama_resort_management.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAllByEmployeeStatusTrue(pageable);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(int employeeId) {
        iEmployeeRepository.removeById(employeeId);
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> optionalEmployee = iEmployeeRepository.findById(employeeId);
        return optionalEmployee.orElse(null);
    }
}
