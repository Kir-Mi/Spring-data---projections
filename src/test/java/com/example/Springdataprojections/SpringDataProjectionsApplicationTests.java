package com.example.Springdataprojections;

import com.example.Springdataprojections.controller.EmployeeController;
import com.example.Springdataprojections.model.Department;
import com.example.Springdataprojections.model.Employee;
import com.example.Springdataprojections.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
class SpringDataProjectionsApplicationTests {

	@InjectMocks
	private EmployeeController employeeController;
	@Mock
	private EmployeeService employeeService;
	@Test
	void contextLoads() {
	}

	@Test
	void testGetEmployeeDepartmentName() {
		Department department = new Department(1L, "name");
		Employee employee = new Employee(1L, "name", "lastName", "position", 100.0, department);

		when(employeeService.getEmployeeDepartment(1L)).thenReturn(employee.getDepartment().getName());

		String result = employeeController.getEmployeeDepartmentName(1L);

		Assertions.assertEquals(result, department.getName());
	}

	@Test
	void testGetEmployeeFullName() {
		String fullName = "John Doe";

		when(employeeService.getEmployeeFullName(1L)).thenReturn(fullName);

		String result = employeeController.getEmployeeFullName(1L);

		Assertions.assertEquals(fullName, result);
	}

	@Test
	void testGetEmployeePosition() {
		String position = "position";

		when(employeeService.getEmployeePosition(1L)).thenReturn(position);

		String result = employeeController.getEmployeePosition(1L);

		Assertions.assertEquals(result, position);
	}
}
