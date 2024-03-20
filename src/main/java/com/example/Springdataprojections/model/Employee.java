package com.example.Springdataprojections.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Double salary;
    private Department department;
}
