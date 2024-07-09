package com.learn.springboot.mysql.app.service;

import com.learn.springboot.mysql.app.entity.Employee;
import com.learn.springboot.mysql.app.exception.ResourceNotFoundException;
import com.learn.springboot.mysql.app.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @PersistenceContext
    private final EntityManager entityManager;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));

        employee.setName(employeeDetails.getName());
        employee.setPosition(employeeDetails.getPosition());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDepartment(employeeDetails.getDepartment());

        return employeeRepository.save(employee);
    }

    public Employee updateEmployeeWithPatch(Long id, Map<String, Object> employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        updateFields(employee, employeeDetails);
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee updateEmployeeWithPatch(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        updateFields(employee, employeeDetails);
        return entityManager.merge(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));

        employeeRepository.delete(employee);
    }

    private void updateFields(Employee existingEmployee, Map<String, Object> newDetails) {
        Class<? extends Employee> employeeClass = existingEmployee.getClass();

        for (Map.Entry<String, Object> entry : newDetails.entrySet()) {
            String fieldName = entry.getKey();
            Object newValue = entry.getValue();
            System.out.println(fieldName);
            try {
                Field field = employeeClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(existingEmployee, newValue);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Handle exception as needed
                e.printStackTrace();
            }
        }
    }

    private void updateFields(Employee existingEmployee, Employee updatedEmployee) {
        if (updatedEmployee.getName() != null) {
            System.out.println("ok1");
            existingEmployee.setName(updatedEmployee.getName());
        }
        if (updatedEmployee.getPosition() != null) {
            System.out.println("ok2");
            existingEmployee.setPosition(updatedEmployee.getPosition());
        }
        if (updatedEmployee.getSalary() != null) {
            System.out.println("ok3");
            existingEmployee.setSalary(updatedEmployee.getSalary());
        }
    }
}
