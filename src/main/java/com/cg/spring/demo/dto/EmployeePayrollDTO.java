package com.cg.spring.demo.dto;

import com.cg.spring.demo.domain.EmployeePayroll;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {
    Long id;

    @NotNull(message = "Nope")
            @NotEmpty(message = "Nope")
            @Pattern(regexp = "^[A-Za-z]{3,}")
    String name;
    String salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeePayrollDTO(Long id,String name, String salary) {
        this.id=id;
        this.name = name;
        this.salary = salary;
    }

    public EmployeePayrollDTO(EmployeePayroll user){
        this.id = user.getId();
        this.name = user.getName();
        this.salary = user.getSalary();
    }

    public String toString(){
        return "Name: " + name + ", Salary: " + salary;
    }
}
