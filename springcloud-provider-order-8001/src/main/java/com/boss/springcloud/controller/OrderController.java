package com.boss.springcloud.controller;

import com.boss.springcloud.entity.Order;
import com.boss.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/query/{typeid}")
    public Order queryById(@PathVariable("typeid") int typeid){
        return orderService.queryById(typeid);
    }

    @GetMapping("/order/list")
    public List<Order> queryAll(){
        return orderService.queryAll();
    }
}
