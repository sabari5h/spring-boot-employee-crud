package com.example.project_Employees.controller;

import com.example.project_Employees.entity.employees;
import com.example.project_Employees.repository.employeesDAO;
import com.example.project_Employees.service.employeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class usersController {
    private employeeService empService;

    public usersController(employeeService empService) {
        this.empService = empService;
    }

    @GetMapping("/getEmployees")
    public List<employees> getEMployees(){
        return empService.employeesList();
    }

    @GetMapping("/getEmployee/{employeeID}")
    public employees getEmployee(@PathVariable int employeeID){
        return empService.findById(employeeID);
    }

    @PostMapping("/addEmployee") //need to learn patch for partial updation
    public String addEmployee(@RequestBody employees employee){
        empService.postEmployee(employee);
        return "Employee Added Successfully";
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody employees employee){
        empService.putEmployee(employee);
        return "employee updated successfully";
    }

    @DeleteMapping("/deleteEmployee/{ID}")
    public String deleteEmployees(@PathVariable int ID){
        empService.removeEmployee(ID);
        return "employee deleted successfully";
    }
}
