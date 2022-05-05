package com.example.database.controller;

import com.example.database.dao.EmployeeRepository;
import com.example.database.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
    repository.save(employee);
    return "Employee Saved...";
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAll(){
        return repository.findAll();
    }

    @GetMapping("/getEmployees/{dept}")
    public List<Employee> getEmployeesByDept(@PathVariable String dept){
        return repository.findByDept(dept);
    }
}
