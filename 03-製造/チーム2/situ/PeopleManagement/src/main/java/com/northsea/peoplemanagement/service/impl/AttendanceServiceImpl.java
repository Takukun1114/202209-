package com.northsea.peoplemanagement.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsea.peoplemanagement.domain.Attendance;
import com.northsea.peoplemanagement.mapper.AttendanceMapper;
import com.northsea.peoplemanagement.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/14
 * @Description
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public boolean saveAttendance(Attendance attendance) {
        return attendanceMapper.insert(attendance) > 0;
    }
    //返回值为修改了多少行， 用大于0判断是否成功修改

    @Override
    public boolean updateAttendance(Attendance attendance) {
        return attendanceMapper.updateById(attendance) > 0;
    }
    //返回值为修改了多少行， 用大于0判断是否成功修改

    @Override
    public boolean deleteAttendance(String id) {
        return attendanceMapper.deleteById(id) > 0;
    }
    //返回值为修改了多少行， 用大于0判断是否成功修改

    @Override
    public List<Attendance> getAll() {
        return attendanceMapper.selectList(null);
    }

    @Override
    public Attendance getById(String id) {
        return attendanceMapper.selectById(id);
    }

    @Override
    public IPage<Attendance> getPage(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public IPage<Attendance> getPage(int currentPage, int pageSize, Attendance attendance) {
        return null;
    }
}
