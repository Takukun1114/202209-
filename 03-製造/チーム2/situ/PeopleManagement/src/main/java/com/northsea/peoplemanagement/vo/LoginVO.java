package com.northsea.peoplemanagement.vo;

import com.northsea.peoplemanagement.domain.Employee;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/15
 * @Description
 */
@Data
public class LoginVO implements Serializable {
    private Integer employee_id;
    private String token;
    private Employee employee;
}
