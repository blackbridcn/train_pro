package com.train.service;

import com.train.param.RegisterParam;
import com.train.vo.ResponseVo;

/**
 * Author: yuzzha
 * Date: 2020/5/26 18:55
 * Description: ${DESCRIPTION}
 */
public interface IUserService {


    ResponseVo doRegisterTask(RegisterParam param, String userAgent,String ip);
}
