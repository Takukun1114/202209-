package com.northsea.peoplemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.northsea.peoplemanagement.domain.Attendance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/14
 * @Description
 */
@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance> {
       @Select("select * from t_attendance where record_id = #{record_id}")
       Attendance getByRecordId(String record_id);

       @Insert("INSERT INTO t_attendance(record_id, attendance_date, start_time, end_time, rest_hours, working_hours, overtime_hours, absence_hours, working_status_id, working_details, create_date, create_user_id, update_date, update_user_id, flow_status_id, rec_del_flg) VALUES (#{record_id}, #{attendance_date}, #{start_time}, #{end_time}, #{rest_hours}, #{working_hours}, #{overtime_hours}, #{absence_hours}, #{working_status_id}, #{working_details}, #{create_date}, #{create_user_id}, #{update_date}, #{update_user_id}, #{flow_status_id}, #{rec_del_flg});")
       int insert(Attendance attendance);

       @Select("select * from t_attendance")
       List<Attendance> getAll();


}
