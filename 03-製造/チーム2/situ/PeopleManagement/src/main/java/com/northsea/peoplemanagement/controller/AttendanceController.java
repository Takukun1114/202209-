package com.northsea.peoplemanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.northsea.peoplemanagement.domain.Attendance;
import com.northsea.peoplemanagement.service.AttendanceService;
import com.northsea.peoplemanagement.util.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/14
 * @Description
 */
@RestController
@RequestMapping("/attendances")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public DataResult save(@RequestBody Attendance attendance){
        return new DataResult(attendanceService.save(attendance));
    }

    @GetMapping
    public DataResult getAll(){
        return new DataResult(true, attendanceService.list());
    }

    @PutMapping
    public DataResult update(@RequestBody Attendance attendance){
        return new DataResult(attendanceService.updateAttendance(attendance));
    }

    @DeleteMapping("/{id}")
    public DataResult delete(@PathVariable String id ){
        return new DataResult(attendanceService.deleteAttendance(id));
    }

    @GetMapping("/{id}")
    public DataResult getByRecordId(@PathVariable String id){
        return new DataResult(true, attendanceService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public DataResult getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return new DataResult(true, attendanceService.getPage(currentPage,pageSize));
    }

}
