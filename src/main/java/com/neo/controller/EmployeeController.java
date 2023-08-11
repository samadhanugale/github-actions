package com.neo.controller;

import com.neo.entity.Employee;
import com.neo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;


    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable String employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        return employeeRepository.delete(employeeId);
    }

    @PutMapping("/employee/{employeeId}")
    public String updateEmployee(@PathVariable String employeeId, @RequestBody Employee employee) {
        return employeeRepository.update(employeeId, employee);
    }

    @GetMapping("/")
    public String sayHello() {
        return "API server is up and running";
    }
}
