package com.tiwari.logging_with_aop.controller;

import com.tiwari.logging_with_aop.dto.Employee;
import com.tiwari.logging_with_aop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.createEmployee(emp);
    }

    @GetMapping("/{id}")
    private Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    private List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }


}
