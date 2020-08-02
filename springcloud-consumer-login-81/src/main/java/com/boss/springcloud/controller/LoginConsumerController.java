package com.boss.springcloud.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j2
public class LoginConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8002";

    @RequestMapping("/consumer/login")
    @ResponseBody
    public String Login(String username,String password){
        Map<String,String> map = new HashMap<String,String>();
        map.put("username",username);
        map.put("password",password);
        log.info(map.get("password"));
        return restTemplate.postForObject(REST_URL_PREFIX + "/user/login",map,String.class,username,password);
    }
}
