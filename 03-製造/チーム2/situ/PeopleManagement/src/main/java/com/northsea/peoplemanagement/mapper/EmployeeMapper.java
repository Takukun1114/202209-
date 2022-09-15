package com.northsea.peoplemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.northsea.peoplemanagement.domain.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/8
 * @Description
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
//    @Select("select * from t_employee where employee_id = #{employee_id}")
//    Employee getById(int id);
}
