package com.train.config;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Author: yuzzha
 * Date: 2020/5/28 18:55
 * Description: ${DESCRIPTION}
 */
//Druid连接池的监控信息主要是通过StatFilter 采集的，采集的信息非常全面，包括SQL执行、并发、慢查、执行时间区间分布等
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
        }
)
public class DruidStatFilter {
}
