package com.boss.springcloud.service;

import com.boss.springcloud.entity.Order;
import java.util.List;

public interface OrderService {
    public Order queryById(int typeid);

    public List<Order> queryAll();
}
