package com.northsea.peoplemanagement.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.northsea.peoplemanagement.domain.YearMonth;
import com.northsea.peoplemanagement.mapper.YearMonthMapper;
import com.northsea.peoplemanagement.service.YearMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/27
 * @Description
 */
@Service
public class YearMonthServiceImpl extends ServiceImpl<YearMonthMapper, YearMonth> implements YearMonthService {

    @Autowired
    private YearMonthMapper yearMonthMapper;

    @Override
    public YearMonth getByYearMonth(String yearMonth) {
        return yearMonthMapper.getByYearMonth(yearMonth);
    }

    @Override
    public List<YearMonth> getByYear(String year) {
        LambdaQueryWrapper<YearMonth> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.likeRight(YearMonth::getAttendance_ym, year);
        List<YearMonth> yearMonthList = yearMonthMapper.selectList(queryWrapper);
        return yearMonthList;
    }

    @Override
    public List<YearMonth> getAll() {
        return yearMonthMapper.selectList(null);
    }

    @Override
    public IPage<YearMonth> getPage(int currentPage, int pageSize) {
        IPage<YearMonth> page = new Page<>(currentPage, pageSize);
        yearMonthMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<YearMonth> getPage(int currentPage, int pageSize, YearMonth yearMonth) {
        IPage<YearMonth> page = new Page<>(currentPage, pageSize);
        yearMonthMapper.selectPage(page, null);
        return page;
    }
}
