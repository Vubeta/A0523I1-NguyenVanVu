package com.example.furama_resort_management.service.customer;

import com.example.furama_resort_management.model.customer.Customer;
import com.example.furama_resort_management.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAllByCustomerStatusTrue(pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int customerId) {
        iCustomerRepository.removeById(customerId);
    }

    @Override
    public Customer findById(int customerId) {
        Optional<Customer> optionalCustomer = iCustomerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }
}
