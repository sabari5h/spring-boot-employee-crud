package com.example.project_Employees.service;

import com.example.project_Employees.entity.employees;
import com.example.project_Employees.exceptionHandler.employeeNotFoundException;
import com.example.project_Employees.repository.employeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class employeeServiceImpl implements employeeService {
    private employeeRepository employeeRepo;

    public employeeServiceImpl(employeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<employees> employeesList(){
        return employeeRepo.findAll();
    }

    public employees findById(int id){
        return employeeRepo.findById(id).orElseThrow(() -> new employeeNotFoundException("not found"));
    }

    public void postEmployee(employees employee){
        employeeRepo.save(employee);
    }

    public String putEmployee(employees employee){
        employeeRepo.save(employee);
        return "updated";
    }

    public void removeEmployee(int id){
        employeeRepo.deleteById(id);
    }
}
