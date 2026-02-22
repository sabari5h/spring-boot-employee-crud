package com.example.project_Employees.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class globalHandler {

    @ExceptionHandler
    public ResponseEntity<responseEntity> exception(employeeNotFoundException execute){
        responseEntity response = new responseEntity();

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(execute.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new  ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
