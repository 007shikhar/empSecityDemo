package com.example.EmpSecurity.services;

import com.example.EmpSecurity.model.Employee;

public interface EmpService {

    //create
    public Employee createEmp(Employee employee);

    //read
    public Employee getEmployee(int empId);

    //update
    public Employee updateEmployee(int empId, Employee employee);

    //delete
    public void deleteEmployee(int empId);
}
