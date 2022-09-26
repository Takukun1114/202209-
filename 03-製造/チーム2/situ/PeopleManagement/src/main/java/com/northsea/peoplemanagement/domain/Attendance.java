package com.northsea.peoplemanagement.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/14
 * @Description
 */
@Data
@TableName(value = "t_attendance")
public class Attendance {
    @TableId
    private String record_id;
    private String attendance_date;
    private String start_time;
    private String end_time;
    private double rest_hours;
    private double working_hours;
    private double overtime_hours;
    private double absence_hours;
    private int working_status_id;
    private String working_details;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Date create_date;
    private int create_user_id;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Date update_date;
    private int update_user_id;
    private int flow_status_id;
    @TableLogic
    private int rec_del_flg;
}
