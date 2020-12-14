package com.cg.spring.demo.repository;

import com.cg.spring.demo.domain.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayroll,Long> {
}
