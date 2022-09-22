package com.northsea.peoplemanagement.vo;

import lombok.Data;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/22
 * @Description
 */
@Data
public class EmployeeVO {
    private int employee_id;
    private String employee_name;
    private int dept_id;
    private String dept_name;
}
