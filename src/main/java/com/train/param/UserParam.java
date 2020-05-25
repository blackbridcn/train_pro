package com.train.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class UserParam {

    @ApiModelProperty("neme")
    private String name;
    @ApiModelProperty("phone")
    private String phone;
    @ApiModelProperty("sex")
    private int sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserParam{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                '}';
    }
}
