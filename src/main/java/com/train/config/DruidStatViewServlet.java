package com.train.config;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Author: yuzzha
 * Date: 2020/5/28 18:56
 * Description: ${DESCRIPTION}
 */
@WebServlet(urlPatterns="/druid/*",
        initParams={
                @WebInitParam(name="allow",value=""),
                @WebInitParam(name="deny",value=""),
                @WebInitParam(name="loginUsername",value="admin"),
                @WebInitParam(name="loginPassword",value="admin"),
                @WebInitParam(name="resetEnable",value="false")
        })
public class DruidStatViewServlet {
}
