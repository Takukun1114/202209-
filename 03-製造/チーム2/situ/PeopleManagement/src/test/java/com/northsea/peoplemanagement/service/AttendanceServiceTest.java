package com.northsea.peoplemanagement.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.northsea.peoplemanagement.domain.Attendance;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        attendance.setWorking_hours(8.0);
        attendance.setRest_hours(1.0);
        attendance.setOvertime_hours(0.0);
        attendance.setAbsence_hours(0.0);
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
    void getWorkingDetails(){
        LambdaQueryWrapper<Attendance> lambdaQueryWrapper = new LambdaQueryWrapper<Attendance>();
        lambdaQueryWrapper.like(Attendance::getRecord_id, "100012022091401");
        attendanceService.getOne(lambdaQueryWrapper);
    }

    @Test
    void getByDateTest(){
        LambdaQueryWrapper<Attendance> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Attendance::getAttendance_date, "2022-09-14");
        List<Attendance> attendances = attendanceService.list();
    }

    @Test
    void getByRecordIdTest(){
        LambdaQueryWrapper<Attendance> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Attendance::getRecord_id, "100012022091403");
        attendanceService.getOne(lambdaQueryWrapper);
    }

    @Test
    void getPagesTest(){
        IPage<Attendance> page = attendanceService.getPage(1,10);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());
    }

    @Test
    void getInfoBySearchTest(){
        IPage<Attendance> page = attendanceService.getAllBySearch(1, 10, "2022-09-14");
        System.out.println(page.getRecords());
    }

    @Test
    void deleteRecordTest(){
        attendanceService.deleteAttendance("100012022091403");
    }
}
