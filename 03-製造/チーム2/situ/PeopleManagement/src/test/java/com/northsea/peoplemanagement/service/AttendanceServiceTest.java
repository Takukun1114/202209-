package com.northsea.peoplemanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.northsea.peoplemanagement.domain.Attendance;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/15
 * @Description
 */
@SpringBootTest
public class AttendanceServiceTest {
    @Autowired
    private AttendanceService attendanceService;

    @Test
    void saveRecordTest(){
        Attendance attendance = new Attendance();
        attendance.setRecord_id("100032022091502");
        attendance.setStart_time("");
        attendance.setEnd_time("");
        attendance.setAttendance_date("2022-09-15");
        attendance.setWorking_hours(8);
        attendance.setRest_hours(1);
        attendance.setOvertime_hours(0);
        attendance.setAbsence_hours(0);
        attendance.setRec_del_flg(0);
        attendance.setWorking_details("Code!");
        attendanceService.save(attendance);
    }

    @Test
    void getByIdTest(String id){
        attendanceService.getById("100012022091401");
    }

    @Test
    void getAll(){
        attendanceService.getAll();
    }


    @Test
    void getWorkingDetails(String record_id){
        LambdaQueryWrapper<Attendance> lambdaQueryWrapper = new LambdaQueryWrapper<Attendance>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(record_id), Attendance::getRecord_id, "100012022091401");
        attendanceService.getOne(lambdaQueryWrapper);
    }
}
