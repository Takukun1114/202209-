package com.northsea.peoplemanagement.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/8
 * @Description
 */

//Entity
@Data
@TableName(value = "t_employee")
public class Employee {
    @TableId(type = IdType.AUTO)
    private Integer employee_id;
    private String employee_name;
    @TableField(select = false)
    private String password;
    private String dept_id;
    private Integer del_flg;
    private Date create_date;
    private Integer create_user_id;
    private Date update_date;
    private Integer update_user_id;
    private String employee_email;
}
