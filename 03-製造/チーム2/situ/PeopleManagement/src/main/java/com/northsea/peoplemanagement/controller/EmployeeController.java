package com.northsea.peoplemanagement.controller;

import com.alibaba.druid.util.StringUtils;
import com.northsea.peoplemanagement.domain.Employee;
import com.northsea.peoplemanagement.service.EmployeeService;
import com.northsea.peoplemanagement.util.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    public DataResult getAll(){
        return new DataResult(true, employeeService.list()) ;
    }

    @PostMapping
    public DataResult save(Employee employee){
        return new DataResult(true, employeeService.save(employee)) ;
    }

    @PutMapping
    public DataResult update(Employee employee){
        return new DataResult(true, employeeService.modifyEmployee(employee)) ;
    }

    @GetMapping("/{employee_id}")
    public DataResult getEmployeeById(@PathVariable Integer employee_id){
        return new DataResult(true, employeeService.getEmployeeById(employee_id)) ;
    }
}
