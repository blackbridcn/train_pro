package com.train.service;

import com.train.param.RegisterParam;
import com.train.vo.ResponeVo;

/**
 * Author: yuzzha
 * Date: 2020/5/26 18:55
 * Description: ${DESCRIPTION}
 */
public interface IUserService {


    ResponeVo doRegisterTask(RegisterParam param);
}
