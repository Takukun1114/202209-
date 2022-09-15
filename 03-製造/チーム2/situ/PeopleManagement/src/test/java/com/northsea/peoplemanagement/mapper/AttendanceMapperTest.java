package com.northsea.peoplemanagement.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.northsea.peoplemanagement.domain.Attendance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/14
 * @Description
 */
@SpringBootTest
public class AttendanceMapperTest {
    @Autowired
    private AttendanceMapper attendanceMapper;

    @Test
    void getByIdWithMpTest() {
        System.out.println(attendanceMapper.selectById("100012022091401"));
    }

    @Test
    void getByRecordIdTest(){
        System.out.println(attendanceMapper.getByRecordId("100012022091401"));
    }


    @Test
    void insertRecordTest(){
        Attendance attendance = new Attendance();
        attendance.setRecord_id("100032022091501");
        attendance.setStart_time("");
        attendance.setEnd_time("");
        attendance.setAttendance_date("2022-09-15");
        attendance.setWorking_hours(8);
        attendance.setRest_hours(1);
        attendance.setOvertime_hours(0);
        attendance.setAbsence_hours(0);
        attendanceMapper.insert(attendance);
    }

    @Test
    void getPagesTest(){
        IPage<Attendance> page = new Page<>(1,10);
        attendanceMapper.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
    }

    @Test
    void getByTest(){
        LambdaQueryWrapper<Attendance> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Attendance::getRecord_id,"100012022091401");
        attendanceMapper.selectList(queryWrapper);
    }
}
