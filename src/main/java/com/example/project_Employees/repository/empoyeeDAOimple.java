package com.example.project_Employees.repository;

import com.example.project_Employees.entity.employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class empoyeeDAOimple implements employeesDAO {
    private EntityManager entitymanager;

    public empoyeeDAOimple(EntityManager entitymanager) {
        this.entitymanager = entitymanager;
    }

    @Override
    public List<employees> findAll() {
        TypedQuery<employees> Query = entitymanager.createQuery("from employees", employees.class);
        List<employees> employeesList = Query.getResultList();
        return employeesList;
    }

    @Override
    public employees findById(int id) {
        employees findEmployee = entitymanager.find(employees.class, id);
        return findEmployee;
    }

    @Override
    public void addEmployee(employees employee) {
        employee.setId(0);
        entitymanager.persist(employee);
    }

    @Override
    public void updateEmployee(employees employee) {
        entitymanager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        employees employee = entitymanager.find(employees.class, id);
        entitymanager.remove(employee);
    }
}
