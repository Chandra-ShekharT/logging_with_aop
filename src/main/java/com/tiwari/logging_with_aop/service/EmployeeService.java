package com.tiwari.logging_with_aop.service;


import com.tiwari.logging_with_aop.config.CustomException;
import com.tiwari.logging_with_aop.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService  {

    List<Employee> list = new ArrayList<>();


    public Employee createEmployee(Employee emp) {

        list.add(new Employee(1L, "sudhanshu", "consultate", "mumbai"));
        list.add(new Employee(2L, "chintamuni", "industrialist", "jaunpur"));
        return emp;

    }

    public Employee getEmployeeById(Long id) {

        return list.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElseThrow(() -> new CustomException("employee not found "+id));

    }


    public List<Employee> getAllEmployee() {

        return list;
    }
}
