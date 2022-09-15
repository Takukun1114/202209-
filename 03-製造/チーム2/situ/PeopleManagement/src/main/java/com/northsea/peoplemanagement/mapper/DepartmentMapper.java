package com.northsea.peoplemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.northsea.peoplemanagement.domain.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/14
 * @Description
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    @Select("select * from m_dept where dept_id = #{dept_id};")
    Department getByDeptId(String dept_id);
}
