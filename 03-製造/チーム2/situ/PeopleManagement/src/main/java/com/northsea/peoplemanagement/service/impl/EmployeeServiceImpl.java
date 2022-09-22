package com.northsea.peoplemanagement.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsea.peoplemanagement.domain.Employee;
import com.northsea.peoplemanagement.mapper.EmployeeMapper;
import com.northsea.peoplemanagement.service.EmployeeService;
import com.northsea.peoplemanagement.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/8
 * @Description
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public boolean insertEmployee(Employee employee) {
        return employeeMapper.insert(employee) > 0;
    }

    @Override
    public boolean modifyEmployee(Employee employee) {
        return employeeMapper.updateById(employee) > 0;
    }

    @Transactional
    @Override
    public boolean deleteEmployee(Integer id) {
        return employeeMapper.deleteById(id) > 0;
    }

    @Override
    public EmployeeVO getEmployeeById(Integer employee_id){
        return employeeMapper.getEmployeeById(employee_id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeMapper.selectList(null);
    }

    @Override
    public IPage<Employee> getPage(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public IPage<Employee> getPage(int currentPage, int pageSize, Employee employee) {
        return null;
    }
}
