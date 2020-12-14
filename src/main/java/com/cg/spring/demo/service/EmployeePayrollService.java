package com.cg.spring.demo.service;

import com.cg.spring.demo.domain.EmployeePayroll;
import com.cg.spring.demo.dto.EmployeePayrollDTO;
import com.cg.spring.demo.exceptions.DetailsNotProvidedExceptions;
import com.cg.spring.demo.exceptions.UserNotFound;
import com.cg.spring.demo.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    //http:/localhost:8080/employee-payroll/create (dto)
    public EmployeePayrollDTO CreateUser(EmployeePayrollDTO employeePayrollDto){
        if(Objects.nonNull(employeePayrollDto.getName()) && Objects.nonNull(employeePayrollDto.getSalary()) &&
                Objects.nonNull(employeePayrollDto.getGender()) && Objects.nonNull(employeePayrollDto.getDepartment()) &&
                Objects.nonNull(employeePayrollDto.getStartDate())) {
            EmployeePayroll employeePayroll = new EmployeePayroll(employeePayrollDto.getName(),employeePayrollDto.getSalary(),
                                                                    employeePayrollDto.getGender(),employeePayrollDto.getDepartment(),
                                                                    employeePayrollDto.getStartDate());
            return new EmployeePayrollDTO(employeePayrollRepository.save(employeePayroll));
        }

        throw new DetailsNotProvidedExceptions("Invalid Data");
    }

    //http:/localhost:8080/employee-payroll/update
    public EmployeePayrollDTO UpdateUser(EmployeePayrollDTO employeePayrollDto){

        return employeePayrollRepository.findById(employeePayrollDto.getId()).map(employeePayroll -> {
            if(Objects.nonNull(employeePayrollDto.getName())){
                employeePayroll.setName(employeePayrollDto.getName());
            }
            if(Objects.nonNull(employeePayroll.getSalary())){
                employeePayroll.setSalary(employeePayroll.getSalary());
            }
            if(Objects.nonNull(employeePayroll.getGender())){
                employeePayroll.setGender(employeePayroll.getGender());
            }
            if(Objects.nonNull(employeePayroll.getDepartment())){
                employeePayroll.setDepartment(employeePayroll.getDepartment());
            }
            if(Objects.nonNull(employeePayroll.getStartDate())){
                employeePayroll.setStartDate(employeePayroll.getStartDate());
            }
            return new EmployeePayrollDTO(employeePayrollRepository.save(employeePayroll));
        }).orElseThrow(()-> new UserNotFound("UserNotFound"));
    }

    //http:/localhost:8080/employee-payroll/delete/{id}
    public EmployeePayrollDTO deleteUser(Long id){
        return employeePayrollRepository.findById(id).map(employeePayroll -> {
            employeePayrollRepository.deleteById(employeePayroll.getId());
            return new EmployeePayrollDTO(employeePayroll);
        }).orElseThrow(()-> new UserNotFound("UserNotFound"));
    }


    public List<EmployeePayrollDTO> getAllUser(){
        return employeePayrollRepository.findAll()
                .stream()
                .map(employeePayroll -> new EmployeePayrollDTO(employeePayroll))
                .collect(Collectors.toList());
    }
}
