package com.train.enums;

/**
 * Author: yuzzha
 * Date: 2020/5/27 14:00
 * Description: ${DESCRIPTION}
 */
public enum RegisterTypeEnum {

    /**
     * 注册方式: 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
     */
    PHONE(1, "手机号"),
    EMIAL(2, "邮箱"),
    USERNAME(3, "用户名"),
    QQ(4, "QQ"),
    WECHAT(5, "微信 "),
    ALIPAY(6, "支付宝"),
    SINABLOG(7, "新浪微博");

    private int code;
    private String desc;

    RegisterTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
