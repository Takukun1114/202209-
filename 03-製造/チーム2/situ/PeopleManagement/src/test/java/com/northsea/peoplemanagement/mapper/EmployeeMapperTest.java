package com.northsea.peoplemanagement.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.northsea.peoplemanagement.domain.Employee;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/8
 * @Description
 */
@SpringBootTest
public class EmployeeMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void getByIdTest() {
        System.out.println(employeeMapper.getEmployeeById(10001));
    }

    @Test
    void getByIdWithMpTest() {
        System.out.println(employeeMapper.selectById(10001));
    }

    @Test
    void insertUserWithMpTest() {
        Employee employee = new Employee();

        employee.setEmployee_id(10006);
        employee.setEmployee_name("田中二郎");
        employee.setPassword("12345678");
        employee.setEmployee_email("abc@gmail.com");
        employee.setCreate_user_id(1);
        employee.setCreate_date(new java.util.Date());
        employee.setDept_id("1");
        employeeMapper.insert(employee);
    }

    @Test
    void updatetUserByIdWithMpTest() {
        Employee employee = new Employee();
        employee.setEmployee_id(10006);
        employee.setEmployee_name("田中二郎");
        employee.setPassword("12345678");
        //employee.setEmployee_email("abcdefg@gmail.com");
        employee.setCreate_user_id(2);
        employee.setCreate_date(new java.util.Date());
        employee.setDept_id("1");
        employeeMapper.updateById(employee);
    }

    @Test
    void getAllWithMpTest() {
        System.out.println(employeeMapper.selectList(null));
    }

    //分页
    @Test
    void GetPageTest() {
        IPage<Employee> page = new Page<Employee>(1, 10);
        employeeMapper.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
    }

    //条件查询
    @Test
    void getByCondition(String name){
        IPage<Employee> page = new Page<Employee>(1, 10);
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<Employee>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(name), Employee::getEmployee_name, name);
        employeeMapper.selectPage(page, lambdaQueryWrapper);
    }
}