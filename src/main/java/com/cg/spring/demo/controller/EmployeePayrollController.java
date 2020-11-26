package com.cg.spring.demo.controller;


import com.cg.spring.demo.dto.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

    @GetMapping("/employee")
    public ResponseEntity<String> getEmployeePayroll(){
        return new ResponseEntity<String>("Get Response from get server ", HttpStatus.OK);
    }

    @GetMapping("/getid/{empId}")
    public ResponseEntity<String> getEmployeeId(@PathVariable (value = "empId") int empId){
        return new ResponseEntity<String>("Get response from server"+empId,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO empDTO){
        return new ResponseEntity<String>("Get response from server"+empDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO empDTO) {
        return new ResponseEntity<String>("Get response from put server "+empDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value="empid") int empid) {
        return new ResponseEntity<String>("Get response from delete server "+empid,HttpStatus.OK);
    }
}
