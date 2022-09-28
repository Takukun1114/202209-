package com.northsea.peoplemanagement.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/27
 * @Description
 */
@Data
@TableName(value = "m_attendance_ym")
public class YearMonth {
    @TableId
    private Integer id;
    private String attendance_ym;
    private Integer display_flg;
    @TableLogic
    private Integer del_flg;
    private Date create_date;
    private Integer create_user_id;
    private Date update_date;
    private Integer update_user_id;
}
