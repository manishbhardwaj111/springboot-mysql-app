package com.learn.springboot.mysql.app.repository;

import com.learn.springboot.mysql.app.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
