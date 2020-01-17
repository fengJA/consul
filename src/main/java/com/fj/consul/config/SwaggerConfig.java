package com.fj.consul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2    // 开启Swagger2
public class SwaggerConfig {

    // 可以有好久个组，只要写几个实例就可以了
    @Bean
    public Docket group1(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("fengjia");
    }

    @Bean
    public Docket group2(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("FJ");
    }

    @Bean
    public Docket docket(Environment environment){
        Profiles profiles = Profiles.of("dev", "test");// 表示在开发、测试环境Swagger有效

        boolean flag = environment.acceptsProfiles(profiles);// 判断是否处于自己设定的环境中

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag);
    }

    // 配置了Swagger的Docket的bean实例
    /*@Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())

                // enable配置是否启动Swagger，默认true
                .enable(false)

                .select()
                // RequestHandlerSelectors:配置要扫描的接口的方式
                // basePackage：指定要扫描的包
                // any:扫描所有的包
                // none:不扫描任何包
                // withClassAnnotation(RestController.class)：扫描有RestController注解的类
                .apis(RequestHandlerSelectors.basePackage("com.fj.consul"))
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                // 过滤路径，过滤掉controller/**下面的东西
//                .paths(PathSelectors.ant("com.fj.consul.controller/**"))
                .build();
    }*/


    public ApiInfo apiInfo(){
        Contact DEFAULT_CONTACT = new Contact("FJ", "http://www.baidu.com", "m15881760105@163.com");

        return new ApiInfo("FJ-Swagger-Documention",
                "Api Documentation",
                "v1.0",
                "http://www.baidu.com",
                DEFAULT_CONTACT, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList());
    }

}
