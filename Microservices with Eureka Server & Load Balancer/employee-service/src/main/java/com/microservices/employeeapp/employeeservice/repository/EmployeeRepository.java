package com.microservices.employeeapp.employeeservice.repository;

import com.microservices.employeeapp.employeeservice.Entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{

    Employee findById(int id);
}
