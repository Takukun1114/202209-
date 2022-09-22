package com.northsea.peoplemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.northsea.peoplemanagement.domain.Employee;
import com.northsea.peoplemanagement.vo.EmployeeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/8
 * @Description
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    @Select("SELECT t1.employee_id, t1.employee_name, t1.dept_id, m1.dept_name FROM t_employee t1 INNER JOIN m_dept m1 ON t1.dept_id = m1.dept_id WHERE t1.employee_id = #{employee_id} and t1.del_flg = 0")
    EmployeeVO getEmployeeById(int employee_id);


}
