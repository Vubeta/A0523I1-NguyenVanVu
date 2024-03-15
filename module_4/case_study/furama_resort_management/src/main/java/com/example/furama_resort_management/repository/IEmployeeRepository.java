package com.example.furama_resort_management.repository;

import com.example.furama_resort_management.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByEmployeeStatusTrue(Pageable pageable);
    @Modifying
    @Query("update Employee e set e.employeeStatus = false where e.employeeId = :id")
    void removeById(@Param("id") int id);
}
