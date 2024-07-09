package com.learn.springboot.mysql.app.service;

import com.learn.springboot.mysql.app.entity.Department;
import com.learn.springboot.mysql.app.entity.Employee;
import com.learn.springboot.mysql.app.repository.DepartmentRepository;
import com.learn.springboot.mysql.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department("Engineering"));
        departments.add(new Department("Human Resources"));
        departments.add(new Department("Sales"));
        departments.add(new Department("Marketing"));
        departments.add(new Department("Finance"));

        departmentRepository.saveAll(departments);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", "Software Engineer", 60000.0, departments.get(0)));
        employees.add(new Employee("Jane Smith", "HR Manager", 65000.0, departments.get(1)));
        employees.add(new Employee("Alice Johnson", "Sales Representative", 55000.0, departments.get(2)));
        employees.add(new Employee("Bob Brown", "Marketing Coordinator", 50000.0, departments.get(3)));
        employees.add(new Employee("Charlie Davis", "Financial Analyst", 70000.0, departments.get(4)));

        employees.add(new Employee("Emily Wilson", "DevOps Engineer", 62000.0, departments.get(0)));
        employees.add(new Employee("Michael Miller", "HR Assistant", 48000.0, departments.get(1)));
        employees.add(new Employee("Sophia White", "Sales Manager", 75000.0, departments.get(2)));
        employees.add(new Employee("James Green", "Marketing Manager", 72000.0, departments.get(3)));
        employees.add(new Employee("Linda Thompson", "Accountant", 68000.0, departments.get(4)));

        employees.add(new Employee("David Moore", "Backend Developer", 59000.0, departments.get(0)));
        employees.add(new Employee("Maria Clark", "Recruiter", 53000.0, departments.get(1)));
        employees.add(new Employee("Oliver Lee", "Sales Associate", 50000.0, departments.get(2)));
        employees.add(new Employee("Lucas Walker", "Content Strategist", 56000.0, departments.get(3)));
        employees.add(new Employee("Emma Harris", "Financial Advisor", 71000.0, departments.get(4)));

        employeeRepository.saveAll(employees);
    }
}
