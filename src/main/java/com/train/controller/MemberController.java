package com.train.controller;

import com.train.param.RegisterParam;
import com.train.service.IUserService;
import com.train.utils.IPUtils;
import com.train.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(value = "账号 Controller ")
@RestController
@RequestMapping("user/api/v1")
public class MemberController {

    @Autowired
    IUserService userService;

    @ApiOperation("账号注册")
    @ResponseHeader(description = "application/json")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseVo register(HttpServletRequest request, @RequestBody RegisterParam param) {
        return userService.doRegisterTask(param,request.getHeader("user-agent"),IPUtils.getIPAddress(request));
    }

}
