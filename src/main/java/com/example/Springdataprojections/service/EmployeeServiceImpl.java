package com.example.Springdataprojections.service;

import com.example.Springdataprojections.exception.NotFoundException;
import com.example.Springdataprojections.model.Employee;
import com.example.Springdataprojections.repository.DepartmentRepository;
import com.example.Springdataprojections.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public String getEmployeeDepartment(Long id) {
        return employeeRepository.findEmployeeProjectionByEmployeeId(id).getDepartmentName();
    }

    public String getEmployeeFullName(Long id) {
        return employeeRepository.findEmployeeProjectionByEmployeeId(id).getFullName();
    }

    public String getEmployeePosition(Long id) {
        return employeeRepository.findEmployeeProjectionByEmployeeId(id).getPosition();
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found", HttpStatus.NOT_FOUND));
    }

    public Employee create(Employee employee) {
        departmentRepository.save(employee.getDepartment());
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found", HttpStatus.NOT_FOUND));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDepartment(employee.getDepartment());
        return employeeRepository.save(existingEmployee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
