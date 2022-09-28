package com.northsea.peoplemanagement.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(value = 0, message = "<0")
    @Max(value = 24, message = ">24")
    private Double rest_hours;
    private Double working_hours;
    private Double overtime_hours;
    private Double absence_hours;
    private Integer working_status_id;
    private String working_details;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Date create_date;
    private Integer create_user_id;
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private Date update_date;
    private Integer update_user_id;
    private Integer flow_status_id;
    @TableLogic
    private Integer rec_del_flg;
    @Version
    private Integer version;
}
