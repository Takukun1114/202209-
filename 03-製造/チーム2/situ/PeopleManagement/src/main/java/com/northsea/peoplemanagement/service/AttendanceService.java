package com.northsea.peoplemanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.northsea.peoplemanagement.domain.Attendance;

import java.util.List;

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

    IPage<Attendance> getPage(int currentPage, int pageSize);

    IPage<Attendance> getPage(int currentPage, int pageSize, Attendance attendance);
}
