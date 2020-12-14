package com.cg.spring.demo.dto;

import com.cg.spring.demo.domain.EmployeePayroll;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class EmployeePayrollDTO {
    Long id;

    @NotNull(message = "Nope")
            @NotEmpty(message = "Nope")
            @Pattern(regexp = "^[A-Za-z]{3,}")
    String name;
    String salary;
    String gender;
    String[] department;
    Date startDate;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getDepartment() {
        return department;
    }

    public void setDepartment(String[] department) {
        this.department = department;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

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

    public EmployeePayrollDTO(Long id, @NotNull(message = "Nope") @NotEmpty(message = "Nope") @Pattern(regexp = "^[A-Za-z]{3,}") String name, String salary, String gender, String[] department, Date startDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
        this.startDate = startDate;
    }

    public EmployeePayrollDTO(EmployeePayroll user){
        this.id = user.getId();
        this.name = user.getName();
        this.salary = user.getSalary();
        this.gender = user.getGender();
        this.department = user.getDepartment();
        this.startDate = user.getStartDate();
    }

    public String toString(){
        return "Name: " + name + ", Salary: " + salary;
    }
}
