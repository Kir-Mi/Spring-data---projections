package com.example.Springdataprojections.service;

import com.example.Springdataprojections.model.Employee;

import java.util.List;

public interface EmployeeService {
    String getEmployeeDepartment(Long id);
    String getEmployeeFullName(Long id);
    String getEmployeePosition(Long id);
    List<Employee> getAll();
    Employee getById(Long id);
    Employee create(Employee employee);
    Employee update(Long id, Employee employee);
    void delete(Long id);
}
