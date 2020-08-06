package com.boss.springcloud.controller;

import com.boss.springcloud.entity.vo.OrderVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@Log4j2
public class OrderConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001";



    @RequestMapping("/consumer/order/query/{typeid}")
    public OrderVo queryById(@PathVariable("typeid") int typeid){
        return restTemplate.getForObject(REST_URL_PREFIX + "/order/query/" + typeid,OrderVo.class);
    }

    @RequestMapping("/consumer/order/list")
    public List<OrderVo> queryAll(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/order/list",List.class);
    }

    @RequestMapping("/consumer/order/add")
    public String add(String name,int typeid,int num){
        return restTemplate.getForObject(REST_URL_PREFIX + "/order/admin/add" + "/"+name+"/"+typeid+"/"+num,String.class);
    }

    @RequestMapping("/consumer/order/delete")
    public String delete(int typeid){
        return restTemplate.getForObject(REST_URL_PREFIX + "/order/admin/delete"+"/"+typeid,String.class);
    }

    @RequestMapping("/consumer/order/update")
    public String update(int typeid,int num){
        return restTemplate.getForObject(REST_URL_PREFIX + "/order/admin/update"+"/"+typeid+"/"+num,String.class);
    }

}
