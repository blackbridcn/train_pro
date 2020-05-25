package com.train.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2)
                //.useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.basePackage("com.train"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {

        Contact contact = new Contact("train", "http://www.baidu.com", "yuzhu_cn@163.com");

        return new ApiInfoBuilder()
                .contact(contact)
                .title("Train-Swagger")
                .description("swagger构建api文档Demo")
                .version("1.0.1")
                .build();
    }


}
