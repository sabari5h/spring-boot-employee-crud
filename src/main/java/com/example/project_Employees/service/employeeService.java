package com.example.project_Employees.service;

import com.example.project_Employees.entity.employees;
import org.springframework.stereotype.Service;

import java.util.List;

public interface employeeService {
    List<employees> employeesList();
    employees findById(int id);
    void postEmployee(employees employee);
    String putEmployee(employees employee);
    public void removeEmployee(int id);
}
