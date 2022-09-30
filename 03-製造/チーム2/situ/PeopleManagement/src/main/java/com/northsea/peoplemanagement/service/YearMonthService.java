package com.northsea.peoplemanagement.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.northsea.peoplemanagement.domain.YearMonth;

import java.util.List;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/27
 * @Description
 */

public interface YearMonthService extends IService<YearMonth> {

    YearMonth getByYearMonth(String yearMonth);

    List<YearMonth> getByYear(String year, String employee_id);

    List<YearMonth> getAll();

    IPage<YearMonth> getPage(int currentPage, int pageSize);

    IPage<YearMonth> getPage(int currentPage, int pageSize, YearMonth yearMonth);
}
