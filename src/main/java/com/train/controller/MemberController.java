package com.train.controller;

import com.train.param.UserParam;
import com.train.vo.ResponeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "member")
@RestController
@RequestMapping("/api")
public class MemberController {

    @ApiOperation("")
    @RequestMapping(value = "/member" ,method = RequestMethod.POST)
    public ResponeVo getMember(@RequestBody UserParam param){
        ResponeVo<String> responeVo = new ResponeVo<>();
        responeVo.setCode(0);
        responeVo.setData(param.toString());
        return responeVo;
    }

}
