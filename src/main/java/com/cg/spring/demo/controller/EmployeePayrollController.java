package com.cg.spring.demo.controller;

import com.cg.spring.demo.dto.EmployeePayrollDTO;
import com.cg.spring.demo.exceptions.UserNotFound;
import com.cg.spring.demo.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class EmployeePayrollController {

    @Autowired
    EmployeePayrollService employeePayrollService;

    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollDTO> createUser(@RequestBody EmployeePayrollDTO user){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(employeePayrollService.CreateUser(user));
        } catch (UserNotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeePayrollDTO> updateUser(@RequestBody EmployeePayrollDTO user){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.UpdateUser(user));
        } catch (UserNotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeePayrollDTO> deleteUser(@PathVariable("id")Long id){
        try{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeePayrollService.deleteUser(id));
        } catch (UserNotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<EmployeePayrollDTO>> getAllUser(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(employeePayrollService.getAllUser());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
