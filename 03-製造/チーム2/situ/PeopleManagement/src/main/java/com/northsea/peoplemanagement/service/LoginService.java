package com.northsea.peoplemanagement.service;

import com.northsea.peoplemanagement.dto.LoginDTO;
import com.northsea.peoplemanagement.result.Result;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/15
 * @Description
 */

public interface LoginService {
    public Result login(LoginDTO loginDTO);
}
