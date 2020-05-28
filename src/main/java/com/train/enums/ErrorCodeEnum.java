package com.train.enums;

/**
 * Author: yuzzha
 * Date: 2020/5/27 11:29
 * Description: ${DESCRIPTION}
 */
public class ErrorCodeEnum {


    private int code;
    private String desc;

    private ErrorCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

}
