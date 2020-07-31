package com.boss.springcloud.controller;

import com.boss.springcloud.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("/consumer/order/query/{typeid}")
    public Order queryById(@PathVariable("typeid") int typeid){
        return restTemplate.getForObject(REST_URL_PREFIX + "/order/query/" + typeid,Order.class);
    }

    @RequestMapping("/consumer/order/list")
    public List<Order> queryAll(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/order/list",List.class);
    }

}
