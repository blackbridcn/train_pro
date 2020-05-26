package com.train.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("ResponeVo")
@Data
public class ResponeVo<T> {

    @ApiModelProperty("code")
    private int code;

    @ApiModelProperty("msg")
    private String msg;

    @ApiModelProperty("data")
    private T data;

    public static ResponeVo success(){
        ResponeVo vo = new ResponeVo();
        vo.setData("成功");
        vo.setCode(0);
        vo.setMsg("成功");
        return vo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
