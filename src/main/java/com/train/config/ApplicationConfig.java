package com.train.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author: yuzzha
 * Date: 2020/5/26 18:20
 * Description: ${DESCRIPTION}
 */
@Data
@Component
@ConfigurationProperties(prefix = "config")
public class ApplicationConfig {

    private Boolean encrypt = false;

    private String password = "baf3299a92";

    private long version;

    private String deviceType;

    private String appKey;

    private String appSecret;


}
