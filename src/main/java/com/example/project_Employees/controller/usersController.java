package com.example.project_Employees.controller;

import com.example.project_Employees.entity.employees;
import com.example.project_Employees.service.employeeService;
import com.example.project_Employees.service.employeeServiceImpl;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/api")
public class usersController {
    private employeeService empService;
    private ObjectMapper mapper;

    public usersController(employeeService empService, ObjectMapper mapper) {
        this.empService = empService;
        this.mapper = mapper;
    }

    @GetMapping("/getEmployees")
    public List<employees> getEMployees(){
        return empService.employeesList();
    }

    @GetMapping("/getEmployee/{employeeID}")
    public employees getEmployee(@PathVariable int employeeID){
        return empService.findById(employeeID);
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody employees employee){
        empService.postEmployee(employee);
        return "Employee Added Successfully";
    }

    @DeleteMapping("/deleteEmployee/{ID}")
    public String deleteEmployees(@PathVariable int ID){
        empService.removeEmployee(ID);
        return "employee deleted successfully";
    }
    @PatchMapping("/patch/{ID}")
    public String patchEmployee(@PathVariable int ID, @RequestBody Map<String, Object> patchPayload){

        employees temp = empService.findById(ID);
        if (patchPayload.containsKey("id")){
            throw new IllegalArgumentException("cant update id");
        }
        employees patchedEmployee = apply(patchPayload, temp);
        empService.putEmployee(patchedEmployee);
        return "updated";
    }
    // helper method for patchEmployee
    private employees apply(Map<String, Object> patchPayload, employees temp){

        ObjectNode employeeNode = mapper.convertValue(temp, ObjectNode.class);

        ObjectNode patch = mapper.convertValue(patchPayload, ObjectNode.class);

        employeeNode.setAll(patch);

        return mapper.convertValue(employeeNode, employees.class);
    }
}
