package com.vab.practice.employeerest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vab.practice.employeerest.dao.EmployeeDao;
import com.vab.practice.employeerest.models.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao dao;

    public Employee getEmployee(Integer emp_no) {
        return dao.getEmployee(emp_no);
    }

    public List<Employee> getEmployees() {
        return dao.getEmployees();
    }

    public Employee insertEmployee(Employee emp) {
        return dao.insertEmployee(emp);
    }

    public Employee updateEmployee(Employee emp, Integer emp_no) {
        return dao.updateEmployee(emp, emp_no);
    }

    public void deleteEmployee(Integer emp_no) {
        dao.deleteEmployee(emp_no);
    }
    
}
