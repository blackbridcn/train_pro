package com.train.enums;

public enum BaseEnum {

    ERROR_PARAM(0, "参数错误");

    private int code;
    private String desc;

    BaseEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
