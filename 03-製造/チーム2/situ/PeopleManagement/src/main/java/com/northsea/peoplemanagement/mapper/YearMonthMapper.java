package com.northsea.peoplemanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.northsea.peoplemanagement.domain.YearMonth;
import com.northsea.peoplemanagement.vo.YearMonthVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/27
 * @Description
 */
@Mapper
public interface YearMonthMapper extends BaseMapper<YearMonth> {

    @Select("SELECT * FROM m_attendance_ym WHERE attendance_ym = #{yearMonth}")
    YearMonth getByYearMonth(String yearMonth);

    @Select("SELECT m1.attendance_ym, record_id, SUM(t1.overtime_hours) FROM m_attendance_ym m1 LEFT JOIN t_attendance t1 ON m1.create_user_id = t1.create_user_id GROUP BY t1.create_user_id")
    YearMonthVO getByYearWithSum(String year);
}
