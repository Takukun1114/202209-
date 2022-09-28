package com.northsea.peoplemanagement.vo;

import lombok.Data;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/27
 * @Description
 */
@Data
public class YearMonthVO {
    private String month;
    private Integer days;
    private Integer attendance_days;
    private Integer absence_days;
    private Integer attendance_hours;
    private Integer overtime_hours;
    private String comments;
}
