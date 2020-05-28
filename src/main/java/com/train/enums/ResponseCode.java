package com.train.enums;

/**
 * Author: yuzzha
 * Date: 2020/5/27 11:17
 * Description: ${DESCRIPTION}
 */
public enum ResponseCode {

    /**
     *
     */
    SUCCESS(0,"成功"),

    SYSTEM_ERROR(-1,"系统异常"),

    WECAHT_OPEN_ID_NULL(-2,"openId为空"),

    WECAHT_OPEN_ID_ERROR(-3,"openId 错误"),

    SEEESION_ID_NULL(-4,"sessionId 为空"),

    SEEESION_ID_TIMEOUT(-5,"sessionId 失效");

    private int code;

    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
