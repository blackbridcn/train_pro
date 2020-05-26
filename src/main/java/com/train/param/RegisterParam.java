package com.train.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Author: yuzzha
 * Date: 2020/5/26 18:31
 * Description: ${DESCRIPTION}
 */
@Data
@ApiModel("账号注册Param")
public class RegisterParam {
    /**
     * String phone=jb.containsKey("phone")?jb.getString("phone"):"";
     * String password=jb.containsKey("password")?jb.getString("password"):"";
     * String code=jb.containsKey("code")?jb.getString("code"):"";
     * String email=jb.containsKey("email")?jb.getString("email"):"";
     * String verify_code=jb.containsKey("verify_code")?jb.getString("verify_code"):"";
     * String nick_name=jb.containsKey("nick_name")?jb.getString("nick_name"):"";
     * <p>
     * `username` varchar(255) DEFAULT NULL COMMENT '用户名',
     * `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
     * `gender` varchar(2) DEFAULT NULL COMMENT '性别',
     * `phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
     * `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
     */

    @NotBlank
    @ApiModelProperty("用户名，NotBlank")
    private String userName;

    @ApiModelProperty("别名")
    private String nickName;

    @NotBlank
    @ApiModelProperty("手机号，NotBlank")
    private String phone;

    @Email
    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("密码，NotBlank")
    private String passWord;

}
