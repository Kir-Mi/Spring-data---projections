package com.example.Springdataprojections.controller;

import com.example.Springdataprojections.model.Employee;
import com.example.Springdataprojections.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/dep/{id}")
    public String getEmployeeDepartmentName(@PathVariable("id") Long id) {
        return employeeService.getEmployeeDepartment(id);
    }

    @GetMapping("/name/{id}")
    public String getEmployeeFullName(@PathVariable("id") Long id) {
        return employeeService.getEmployeeFullName(id);
    }

    @GetMapping("/pos/{id}")
    public String getEmployeePosition(@PathVariable("id") Long id) {
        return employeeService.getEmployeePosition(id);
    }

    @GetMapping()
    public List<Employee> getAllEmployee() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getById(id);
    }

    @PostMapping()
    public Employee save(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable("id") Long id, @RequestBody Employee upEmployee) {
        return employeeService.update(id, upEmployee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        employeeService.delete(id);
    }
}
