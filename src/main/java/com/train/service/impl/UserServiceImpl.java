package com.train.service.impl;

import com.train.model.entity.UserData;
import com.train.model.mapper.UserDataMapper;
import com.train.param.RegisterParam;
import com.train.service.IUserService;
import com.train.vo.ResponeVo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: yuzzha
 * Date: 2020/5/26 18:56
 * Description: ${DESCRIPTION}
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDataMapper userDataMapper;

    @Override
    public ResponeVo doRegisterTask(RegisterParam param) {
        UserData userData = new UserData();
        userData.setAvatar_name();
        userDataMapper.insert()
        return null;
    }
}
