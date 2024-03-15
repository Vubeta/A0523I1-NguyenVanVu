package com.example.furama_resort_management.repository;

import com.example.furama_resort_management.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByCustomerStatusTrue(Pageable pageable);
    @Modifying
    @Query("update Customer c set c.customerStatus = false where c.customerId = :id")
    void removeById(@Param("id") int id);
}
