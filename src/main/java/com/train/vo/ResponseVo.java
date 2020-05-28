package com.train.vo;

import com.train.enums.ErrorCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: yuzzha
 * Date: 2020/5/27 11:26
 * Description: ${DESCRIPTION}
 */
@ApiModel("ResponeVo")
@Data
public class ResponseVo<T> {

    @ApiModelProperty("resCode")
    private int resCode;
    @ApiModelProperty("resMsg")
    private String resMsg;
    @ApiModelProperty("data")
    private T data;

    public ResponseVo() {
    }

    public ResponseVo(T data) {
        this.data = data;
    }

    public ResponseVo(int resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo(data);
    }

    public static <T> ResponseVo<T> success() {
        return new ResponseVo((Object) null);
    }

    public static ResponseVo fail(ErrorCodeEnum errorCode) {
        return new ResponseVo(errorCode.getCode(), errorCode.getDesc());
    }

    public static ResponseVo fail(ErrorCodeEnum errorCode, String errorMessage) {
        return new ResponseVo(errorCode.getCode(), errorMessage);
    }

    public static ResponseVo fail(int resCode, String resMsg) {
        return new ResponseVo(resCode, resMsg);
    }

}
