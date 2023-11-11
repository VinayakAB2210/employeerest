package com.vab.practice.employeerest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.vab.practice.employeerest.models.Employee;

@Component
public class EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static String FETCH_EMPLOYEE_BY_ID = " Select * from employees where emp_no = ?";
    private static String FETCH_ALL_EMPLOYEEs = " Select * from employees";
    private static String INSERT_EMPLOYEE = "insert into employees (emp_no, birth_date, first_name, last_name, gender, hire_date) values (?, ?, ?, ?, ?, ?)";
    private static String UPDATE_EMPLOYEE = "update employees set birth_date=?, first_name=?, last_name=?, gender=?, hire_date=? where emp_no=?";
    private static String DELETE_EMPLOYEE = "delete from employees where emp_no=?";

    public Employee getEmployee(Integer emp_no) {
        return jdbcTemplate.query(FETCH_EMPLOYEE_BY_ID, BeanPropertyRowMapper.newInstance(Employee.class), new Object[] {emp_no}).get(0);
    }

    public List<Employee> getEmployees() {
        return jdbcTemplate.query(FETCH_ALL_EMPLOYEEs, BeanPropertyRowMapper.newInstance(Employee.class));
    }

    public Employee insertEmployee(Employee emp) {
        jdbcTemplate.update(INSERT_EMPLOYEE, new Object[] { emp.getEmpNo(), emp.getBirthDate(), emp.getFirstName(), emp.getLastName(), emp.getGender(), emp.getHireDate()});
        return jdbcTemplate.query(FETCH_EMPLOYEE_BY_ID, BeanPropertyRowMapper.newInstance(Employee.class), new Object[] {emp.getEmpNo()}).get(0);
    }

    public Employee updateEmployee(Employee emp, Integer emp_no) {
        jdbcTemplate.update(UPDATE_EMPLOYEE, new Object[] { emp.getBirthDate(), emp.getFirstName(), emp.getLastName(), emp.getGender(), emp.getHireDate(), emp_no});
        return jdbcTemplate.query(FETCH_EMPLOYEE_BY_ID, BeanPropertyRowMapper.newInstance(Employee.class), new Object[] {emp_no}).get(0);
    }

    public void deleteEmployee(Integer emp_no) {
        jdbcTemplate.update(DELETE_EMPLOYEE, new Object[] {emp_no});
    }
    
}
