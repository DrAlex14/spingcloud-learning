package com.boss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //在服务启动后注册到Eureka中
public class LoginProvider_8002 {
    public static void main(String[] args) {
        SpringApplication.run(LoginProvider_8002.class,args);
    }
}
