package com.northsea.peoplemanagement.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsea.peoplemanagement.domain.Attendance;
import com.northsea.peoplemanagement.mapper.AttendanceMapper;
import com.northsea.peoplemanagement.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public boolean saveAttendance(Attendance attendance) {
        return attendanceMapper.insert(attendance) > 0;
    }
    //返回值为修改了多少行， 用大于0判断是否成功修改

    @Transactional
    @Override
    public boolean updateAttendance(Attendance attendance) {
        return attendanceMapper.updateById(attendance) > 0;
    }
    //返回值为修改了多少行， 用大于0判断是否成功修改

//    @Transactional
//    @Override
//    public boolean updateExistingInfo(record_id) {
//        LambdaUpdateWrapper<Attendance> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
//        lambdaUpdateWrapper.eq(Attendance::getRecord_id, record_id);
//        Attendance attendance = new Attendance();
//        attendance.setAttendance_date(attendance_date);
//        attendance.setAbsence_hours(absence_hours);
//        return attendanceMapper.update(attendance) > 0;
//    }

    @Transactional
    @Override
    public boolean deleteAttendance(String record_id) {
        return attendanceMapper.deleteById(record_id) > 0;
    }
    //返回值为修改了多少行， 用大于0判断是否成功修改

    @Transactional
    @Override
    public List<Attendance> getAll() {
        return attendanceMapper.selectList(null);
    }

    @Transactional
    @Override
    public Attendance getById(String id) {
        return attendanceMapper.selectById(id);
    }

    @Transactional
    @Override
    public Attendance getByRecordId(String record_id) {
        return attendanceMapper.getByRecordId(record_id);
    }

    @Transactional
    @Override
    public List<Attendance> getAllNotDel(Integer rec_del_flg) {
        return attendanceMapper.getAllNotDel(rec_del_flg);
    }

    @Override
    public IPage<Attendance> getPage(int currentPage, int pageSize) {
        IPage<Attendance> page = new Page<>(currentPage, pageSize);
        attendanceMapper.selectPage(page, null);
        return page;
    }

    @Transactional
    @Override
    public IPage<Attendance> getMonthPage(String yearMonth, int currentPage, int pageSize) {
        StringBuilder stringBuilder = new StringBuilder(yearMonth);
        stringBuilder.insert(4, "-");
        IPage<Attendance> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Attendance> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(yearMonth)){
            queryWrapper.likeRight(Attendance::getAttendance_date, String.valueOf(stringBuilder));
        }
        return attendanceMapper.selectPage(page, queryWrapper);
    }

    @Transactional
    @Override
    public IPage<Attendance> getAllBySearch(int currentPage, int pageSize, String attendance_date) {
        Page<Attendance> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Attendance> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(attendance_date)){
            queryWrapper.eq("attendance_date", attendance_date);
        }
        return attendanceMapper.selectPage(page, queryWrapper);
    }


}













