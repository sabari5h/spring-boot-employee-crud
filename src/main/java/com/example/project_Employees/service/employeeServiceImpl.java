package com.example.project_Employees.service;

import com.example.project_Employees.entity.employees;
import com.example.project_Employees.exceptionHandler.employeeNotFoundException;
import com.example.project_Employees.repository.employeesDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class employeeServiceImpl {
    private employeesDAO repository;

    public employeeServiceImpl(employeesDAO repository) {
        this.repository = repository;
    }

    public List<employees> employeesList(){
        return repository.findAll();
    }

    public employees findById(int id){
        employees employee = repository.findById(id);
        if (employee == null){
            throw new employeeNotFoundException("employee ID Not found" + id);
        }
        return employee;
    }
    @Transactional
    public String postEmployee(employees employee){
        repository.addEmployee(employee);
        return "saved successfully";
    }
    @Transactional
    public String putEmployee(employees employee){
        int id = employee.getId();
        employees user = repository.findById(id);
        if (user == null){
            throw new employeeNotFoundException("employee Not Found");
        }
        repository.updateEmployee(employee);
        return "updated successfully";
    }
    @Transactional
    public String removeEmployee(int id){
        employees user = repository.findById(id);
        if (user == null){
            throw new employeeNotFoundException("employee Not Found");
        }
        repository.deleteById(id);
        return "deleted successfully";
    }
}
