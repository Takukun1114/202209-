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
        return new DataResult(true,attendanceService.save(attendance));
    }

    @GetMapping
    public DataResult getAll(){
        return new DataResult(true, attendanceService.getAll());
    }

    @PutMapping
    public DataResult update(@RequestBody Attendance attendance){
        return new DataResult(true, attendanceService.updateAttendance(attendance));
    }


    @DeleteMapping("/delete/{record_id}")
    public DataResult delete(@PathVariable String record_id ){
        return new DataResult(true, attendanceService.deleteAttendance(record_id));
    }

    @GetMapping("/details/{record_id}")
    public DataResult getByRecordId(@PathVariable String record_id){
        return new DataResult(true, attendanceService.getByRecordId(record_id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public DataResult getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<Attendance> page = attendanceService.getPage(currentPage, pageSize);
        if (currentPage > page.getPages()){
            page = attendanceService.getPage((int) page.getPages(), pageSize);
        }
        return new DataResult(true, page);
    }

    @GetMapping("/{rec_del_flg}")
    public DataResult getAllNotDel(@PathVariable(value = "rec_del_flg") int rec_del_flg) {
        return new DataResult(true, attendanceService.getAllNotDel(rec_del_flg));
    }

    @GetMapping("/search/{currentPage}/{pageSize}")
    public DataResult getAllBySearch(@PathVariable int currentPage, @PathVariable int pageSize, @RequestParam String attendance_date){
        IPage<Attendance> page = attendanceService.getAllBySearch(currentPage, pageSize, attendance_date);
        if (currentPage > page.getPages()){
            page = attendanceService.getAllBySearch((int) page.getPages(), pageSize, attendance_date);
        }
        return new DataResult(true, page);
    }

}
