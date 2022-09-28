package com.northsea.peoplemanagement.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.northsea.peoplemanagement.domain.YearMonth;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/27
 * @Description
 */
@SpringBootTest
public class YearMonthMapperTest {
    @Autowired
    private YearMonthMapper yearMonthMapper;

    @Test
    void getByYearMonth(){
        System.out.println(yearMonthMapper.getByYearMonth("202208"));
    }

    @Test
    void getMonthsTest(){
        System.out.println(yearMonthMapper.selectList(null));
    }

    @Test
    void getYearTest(){
        String year = "2022";
        LambdaQueryWrapper<YearMonth> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.likeRight(YearMonth::getAttendance_ym, year);
        List<YearMonth> yearMonthList = yearMonthMapper.selectList(queryWrapper);
        for (YearMonth yearmonth: yearMonthList) {
            System.out.println(yearmonth);
        }

    }
}
