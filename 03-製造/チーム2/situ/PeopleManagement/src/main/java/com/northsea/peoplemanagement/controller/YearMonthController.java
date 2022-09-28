package com.northsea.peoplemanagement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.northsea.peoplemanagement.domain.YearMonth;
import com.northsea.peoplemanagement.service.YearMonthService;
import com.northsea.peoplemanagement.util.DataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/27
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/lists")
public class YearMonthController {
    @Autowired
    private YearMonthService yearMonthService;

    @GetMapping
    public DataResult getAll(){
        return new DataResult(true, yearMonthService.getAll());
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public DataResult getPages(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<YearMonth> page = yearMonthService.getPage(currentPage, pageSize);
        if (currentPage > page.getPages()){
            page = yearMonthService.getPage((int)page.getPages(), pageSize);
        }
        return new DataResult(true, page);
    }

    @GetMapping("/{year}")
    public DataResult getByYear(@PathVariable String year){
        System.out.println(year);
        return new DataResult(true, yearMonthService.getByYear(year));
    }
}
