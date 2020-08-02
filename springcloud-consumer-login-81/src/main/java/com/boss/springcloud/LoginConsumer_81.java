package com.boss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoginConsumer_81 {
    public static void main(String[] args) {
        SpringApplication.run(LoginConsumer_81.class,args);
    }
}
