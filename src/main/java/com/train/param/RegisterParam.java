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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
