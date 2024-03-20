package com.example.Springdataprojections.repository;

import com.example.Springdataprojections.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    EmployeeProjection findEmployeeProjectionByEmployeeId(Long employeeId);
}
