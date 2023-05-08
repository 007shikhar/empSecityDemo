package com.example.EmpSecurity.services.impl;

import com.example.EmpSecurity.model.Employee;
import com.example.EmpSecurity.repositories.EmpRepo;
import com.example.EmpSecurity.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepo empRepo;

    @Override
    public Employee createEmp(Employee employee) {
        return this.empRepo.save(employee);
    }

    @Override
    public Employee getEmployee(int empId) {
        return this.empRepo.findById(empId).orElseThrow(() -> new EntityNotFoundException("Employee with id : " +empId+ " not found!"));
    }

    @Override
    public Employee updateEmployee(int empId, Employee employee) {
        
        Employee updateEmp = this.empRepo.findById(empId).orElseThrow(() -> new EntityNotFoundException("Employee with id : " +empId+ " not found!"));
        
        updateEmp.setId(employee.getId());
        updateEmp.setName(employee.getName());
        updateEmp.setAge(employee.getAge());
        updateEmp.setCompany(employee.getCompany());
        
        return this.empRepo.save(updateEmp);
        
    }

    @Override
    public void deleteEmployee(int empId) {
        this.empRepo.deleteById(empId);
    }
}
