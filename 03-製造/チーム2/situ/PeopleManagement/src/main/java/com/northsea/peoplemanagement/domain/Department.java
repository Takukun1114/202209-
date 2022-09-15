package com.northsea.peoplemanagement.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/14
 * @Description
 */
@Data
@TableName(value = "m_dept")
public class Department {
    @TableId
    private String dept_id;
    private String dept_name;
    private int del_flg;
    private Date create_date;
    private int create_user_id;
    private Date update_date;
    private int update_user_id;
}
