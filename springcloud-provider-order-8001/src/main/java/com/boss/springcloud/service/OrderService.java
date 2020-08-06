package com.boss.springcloud.service;

import com.boss.springcloud.entity.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto queryById(int typeid);

    List<OrderDto> queryAll();

    void delete(int typeid);

    void update(int typeid,int num);

    void add(String name,int typeid,int num);
}
