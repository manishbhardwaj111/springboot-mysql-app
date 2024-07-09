package com.learn.springboot.mysql.app.repository;

import com.learn.springboot.mysql.app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
