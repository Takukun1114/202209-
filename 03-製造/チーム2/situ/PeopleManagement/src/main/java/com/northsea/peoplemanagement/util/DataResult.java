package com.northsea.peoplemanagement.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BenSitu
 * @CreateDate 2022/9/15
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResult {
    private Boolean flag;
    private Object data;

    public DataResult(Boolean flag){
        this.flag = flag;
    }
}
