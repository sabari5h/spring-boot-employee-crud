package com.example.project_Employees.repository;

import com.example.project_Employees.entity.employees;

import java.util.List;

public interface employeesDAO {

    List<employees> findAll();
    employees findById(int id);
    void addEmployee(employees employee);
    void updateEmployee(employees employee);
    void deleteById(int id);
}
