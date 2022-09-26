package com.northsea.peoplemanagement.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/15
 * @Description
 */

@Data
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
}
