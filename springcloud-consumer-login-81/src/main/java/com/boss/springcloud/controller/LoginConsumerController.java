package com.boss.springcloud.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Log4j2
public class LoginConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8002";

    @RequestMapping("/consumer/login")
    @ResponseBody
    public String Login(String username,String password){
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/login/"+username+"/"+password,String.class);
    }

}
