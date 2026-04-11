package com.example.project_Employees.repository;

import com.example.project_Employees.entity.employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<employees, Integer>{
}
