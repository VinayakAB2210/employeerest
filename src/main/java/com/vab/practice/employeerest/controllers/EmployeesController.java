package com.vab.practice.employeerest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vab.practice.employeerest.models.Employee;
import com.vab.practice.employeerest.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/{emp_no}/")
    public Employee getEmployee(@PathVariable("emp_no") Integer emp_no) {
        return service.getEmployee(emp_no);
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return service.getEmployees();
    }

    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.insertEmployee(employee);
    }

    @PutMapping("/{emp_no}/")
    public Employee updateEmployee(@PathVariable("emp_no") Integer emp_no, @RequestBody Employee employee) {
        return service.updateEmployee(employee, emp_no);
    }

    @DeleteMapping("/{emp_no}/")
    public void deleteEmployee(@PathVariable("emp_no") Integer emp_no) {
        service.deleteEmployee(emp_no);
    }
    
}
