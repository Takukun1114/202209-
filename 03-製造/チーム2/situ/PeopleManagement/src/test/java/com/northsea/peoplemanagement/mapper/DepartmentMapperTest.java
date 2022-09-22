package com.northsea.peoplemanagement.mapper;

import com.northsea.peoplemanagement.domain.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/14
 * @Description
 */
@SpringBootTest
public class DepartmentMapperTest {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    void getAll(){
        List<Department> departmentList = departmentMapper.selectList(null);
        System.out.println(departmentList);
    }
}
