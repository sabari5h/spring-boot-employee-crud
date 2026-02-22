package com.example.project_Employees.service;

import com.example.project_Employees.entity.employees;

import java.util.List;

public interface employeeService {
    List<employees> employeesList();
    employees findById(int id);
    String postEmployee(employees employee);
    String putEmployee(employees employee);
    public String removeEmployee(int id);
}
