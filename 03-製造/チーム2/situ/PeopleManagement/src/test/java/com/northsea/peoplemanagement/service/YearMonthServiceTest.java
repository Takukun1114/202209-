package com.northsea.peoplemanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.northsea.peoplemanagement.domain.YearMonth;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/27
 * @Description
 */
@SpringBootTest
public class YearMonthServiceTest {
    @Autowired
    private YearMonthService yearMonthService;

    @Test
    void getByYearMonthTest(String yearMonth){
        yearMonthService.getByYearMonth("202207");
    }

    @Test
    void getAllTest(){
        yearMonthService.getAll();
    }

    @Test
    void getPagesTest(){
        IPage<YearMonth> page = yearMonthService.getPage(1,10);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());
    }

    @Test
    void getByYear(){
        yearMonthService.getByYear("2020");
    }

}
