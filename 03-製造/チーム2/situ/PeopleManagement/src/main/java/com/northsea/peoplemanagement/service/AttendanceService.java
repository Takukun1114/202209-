package com.northsea.peoplemanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.northsea.peoplemanagement.domain.Attendance;

import java.util.List;
import java.util.Map;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/14
 * @Description
 */

public interface AttendanceService extends IService<Attendance> {
    boolean saveAttendance(Attendance attendance);

    boolean updateAttendance(Attendance attendance);

    boolean deleteAttendance(String record_id);

    List<Attendance> getAll();

    Attendance getById(String id);

    Attendance getByRecordId(String id);

    List<Attendance> getAllNotDel(Integer rec_del_flg);

    IPage<Attendance> getPage(int currentPage, int pageSize);

    IPage<Attendance> getPage(int currentPage, int pageSize, Attendance attendance);

    IPage<Attendance> getAllBySearch(int currentPage, int pageSize, String attendance_date);

}
