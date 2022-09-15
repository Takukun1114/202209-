package com.northsea.peoplemanagement.service.impl;

import com.northsea.peoplemanagement.vo.LoginVO;
import org.springframework.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.northsea.peoplemanagement.domain.Employee;
import com.northsea.peoplemanagement.dto.LoginDTO;
import com.northsea.peoplemanagement.mapper.EmployeeMapper;
import com.northsea.peoplemanagement.result.Result;
import com.northsea.peoplemanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/15
 * @Description
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Result login(LoginDTO loginDTO) {
        if (StringUtils.hasText(loginDTO.getEmployeeName())){
            return new Result(400, "ユーザーIDを入力してください","");
        }
        if (StringUtils.hasText(loginDTO.getPassword())){
            return new Result(400, "パスワードを入力してください","");
        }
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("employee_name", loginDTO.getEmployeeName());
        Employee employee = employeeMapper.selectOne(wrapper);

        if ((employee!=null && employee.getPassword().equals(loginDTO.getPassword()))){
            LoginVO loginVO = new LoginVO();
            loginVO.setEmployee_id(employee.getEmployee_id());

            loginVO.setToken(UUID.randomUUID().toString());
            loginVO.setEmployee(employee);
            return new Result(200, "", loginVO);
        }
        return new Result(400, "ログインできません","");
    }
}
