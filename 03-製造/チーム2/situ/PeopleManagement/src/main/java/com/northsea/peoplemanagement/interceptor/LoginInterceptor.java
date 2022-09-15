package com.northsea.peoplemanagement.interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.northsea.peoplemanagement.result.Result;
import com.northsea.peoplemanagement.util.HttpContextUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/15
 * @Description
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws IOException {
        String token = httpServletRequest.getHeader("token");

        if (StringUtils.isBlank(token)) {
            setReturn(httpServletResponse, 401, "Please login");
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) {

    }

    private static void setReturn(HttpServletResponse httpServletResponse, Integer code, String msg) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) httpServletResponse;
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
        //UTF-8编码
        httpResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        Result result = new Result(code,msg,"");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        httpResponse.getWriter().print(json);
    }
}
