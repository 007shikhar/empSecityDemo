package com.example.EmpSecurity.controllers;

import com.example.EmpSecurity.model.Employee;
import com.example.EmpSecurity.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    //create
    @PostMapping("/")
    public ResponseEntity<Employee> createEmp(@RequestBody Employee employee){
        Employee createdEmp = this.empService.createEmp(employee);
        return new ResponseEntity<>(createdEmp, HttpStatus.CREATED);
    }

    //read
    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmp(@PathVariable int empId){
        return new ResponseEntity<>(this.empService.getEmployee(empId), HttpStatus.OK);
    }

    //update
    @PutMapping("/{empId}")
    public ResponseEntity<Employee> updateEmp(@PathVariable int empId, @RequestBody Employee employee){
        return new ResponseEntity<>(this.empService.updateEmployee(empId, employee), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("{empId}")
    public ResponseEntity deleteEmp(@PathVariable int empId){
        this.empService.deleteEmployee(empId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
