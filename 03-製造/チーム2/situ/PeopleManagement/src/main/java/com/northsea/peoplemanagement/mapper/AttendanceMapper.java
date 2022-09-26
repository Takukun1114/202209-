package com.northsea.peoplemanagement.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.northsea.peoplemanagement.domain.Attendance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

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

       @Select("select * from t_attendance where rec_del_flg = #{rec_del_flg}")
       List<Attendance> getAllNotDel(Integer del_flag);

       @Select("select * from t_attendance where rec_del_flg = #{rec_del_flg} and attendance_date = #{attendance_date}")
       List<Attendance> getAllOnSelectedDate(Integer rec_del_flg, String attendance_date);

       @Update("update t_attendance set del_flg=1 where record_id = #{record_id}")
       Attendance updateDelFlg(Attendance attendance);

//       @Update("update t_attendance set record_id = #{record_id}, attendance_date = #{attendance_date}, start_time = #{start_time}, end_time = #{end_time}, rest_hours = #{rest_hours}, working_hours = #{working_hours}, overtime_hours = #{overtime_hours}, absence_hours = #{absence_hours}, working_status_id = #{working_status_id}, working_details = #{working_details}, update_date = #{}, update_user_id = #{update_user_id}, flow_status_id = #{flow_status_id} where record_id = #{record_id}")
//       int updateWithAllInfo(Attendance attendance);
}








