package com.northsea.peoplemanagement.controller;

import com.northsea.peoplemanagement.domain.Employee;
import com.northsea.peoplemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/8
 * @Description
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.list();
    }

    @PostMapping
    public Boolean save(Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping
    public Boolean update(Employee employee){
        return employeeService.modifyEmployee(employee);
    }
}
