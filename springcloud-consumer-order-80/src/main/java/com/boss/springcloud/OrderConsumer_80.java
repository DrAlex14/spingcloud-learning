package com.boss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumer_80.class,args);
    }
}
