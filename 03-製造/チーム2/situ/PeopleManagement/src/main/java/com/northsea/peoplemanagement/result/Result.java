package com.northsea.peoplemanagement.result;

import java.io.Serializable;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/15
 * @Description
 */

public class Result implements Serializable {
    //Response code
    private Integer code;
    //Message
    private String message;
    //Return data
    private Object data;

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
