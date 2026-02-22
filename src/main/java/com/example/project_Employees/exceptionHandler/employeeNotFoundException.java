package com.example.project_Employees.exceptionHandler;


public class employeeNotFoundException extends RuntimeException{
    public employeeNotFoundException(String message) {
        super(message);
    }
}
