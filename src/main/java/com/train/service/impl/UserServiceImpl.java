package com.train.service.impl;

import com.train.enums.RegisterTypeEnum;
import com.train.model.entity.RegisterLog;
import com.train.model.entity.UserData;
import com.train.model.mapper.RegisterLogMapper;
import com.train.model.mapper.UserDataMapper;
import com.train.param.RegisterParam;
import com.train.service.IUserService;
import com.train.utils.RandomUtils;
import com.train.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Author: yuzzha
 * Date: 2020/5/26 18:56
 * Description: ${DESCRIPTION}
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDataMapper userDataMapper;

    @Autowired
    RegisterLogMapper registerLogMapper;

    @Override
    public ResponseVo doRegisterTask(RegisterParam param, String userAgent, String ip) {
        List<UserData> activeUser = userDataMapper.findActiveUser(param);
        if (!CollectionUtils.isEmpty(activeUser)) {
            activeUser.clear();
            activeUser = null;
            return ResponseVo.fail(-1, "该账户已经注册");
        }
        activeUser.clear();
        activeUser = null;
        UserData userData = new UserData();
        RegisterLog log = new RegisterLog();

        userData.setUsername(param.getUserName());
        userData.setPassword(param.getPassWord());
        userData.setPhone(param.getPhone());
        Date date = new Date();
        userData.setCreate_time(date);
        log.setRegister_time(date);
        userData.setIdentity_type(1);
        userData.setIdentifier(param.getPhone());
        userData.setEnabled(1);
        userData.setUid(System.currentTimeMillis());
        log.setUid(userData.getUid());
        if (!StringUtils.isEmpty(param.getNickName())) {
            userData.setNickname(param.getNickName());
        }
        if (!StringUtils.isEmpty(param.getEmail())) {
            userData.setEmail(param.getEmail());
        }
        userData.setCertificate(param.getPhone());
        System.out.println("----------------------------------- \n");
        System.out.println("-------->RegisterParam <:" + userData.toString() + "\n");
        System.out.println("----------------------------------- \n");
        userDataMapper.insert(userData);
        log.setRegister_client(getClient(userAgent));
        log.setRegister_ip(ip);
        log.setRegister_method(RegisterTypeEnum.PHONE.getCode());
        registerLogMapper.insert(log);
        return ResponseVo.success();
    }

    public String getClient(String userAgent) {
        System.out.println("userAgent :"+userAgent);
        if (userAgent != null && userAgent.contains("AlipayClient")) {
            return "来自支付宝";
        }else if (userAgent != null && userAgent.contains("MicroMessenger")) {
            return "来自微信";
        }else{
            return "未知来源";
        }
    }


}
