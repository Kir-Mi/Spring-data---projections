package com.example.Springdataprojections.repository;

import com.example.Springdataprojections.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
