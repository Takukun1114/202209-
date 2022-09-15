package com.northsea.peoplemanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.northsea.peoplemanagement.domain.Employee;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/8
 * @Description
 */
public interface EmployeeService extends IService<Employee> {

    boolean insertEmployee(Employee employee);

    boolean modifyEmployee(Employee employee);

    boolean deleteEmployee(Integer id);

    IPage<Employee> getPage(int currentPage,int pageSize);

    IPage<Employee> getPage(int currentPage, int pageSize, Employee employee);
}
