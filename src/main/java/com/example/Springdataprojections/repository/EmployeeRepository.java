package com.example.Springdataprojections.repository;

import com.example.Springdataprojections.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
