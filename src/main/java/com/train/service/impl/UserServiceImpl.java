package com.train.service.impl;

import com.train.model.entity.UserData;
import com.train.model.mapper.UserDataMapper;
import com.train.param.RegisterParam;
import com.train.service.IUserService;
import com.train.vo.ResponeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * Author: yuzzha
 * Date: 2020/5/26 18:56
 * Description: ${DESCRIPTION}
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDataMapper userDataMapper;

    @Override
    public ResponeVo doRegisterTask(RegisterParam param) {
        UserData userData = new UserData();
        userData.setUsername(param.getUserName());
        userData.setPassword(param.getPassWord());
        userData.setPhone(param.getPhone());
        userData.setCreate_time(new Date());
        userData.setIdentity_type(1);
        userData.setIdentifier(param.getPhone());
        userData.setEnabled(1);
        userData.setUid(UUID.randomUUID().getLeastSignificantBits());
        if (!StringUtils.isEmpty(param.getNickName())) {
            userData.setNickname(param.getNickName());
        }
        if (!StringUtils.isEmpty(param.getEmail())) {
            userData.setEmail(param.getEmail());
        }
        System.out.println("----------------------------------- \n");
        System.out.println("-------->RegisterParam <:" + param.toString() + "\n");
        System.out.println("----------------------------------- \n");
        userDataMapper.insert(userData);
        return ResponeVo.success();
    }
}
