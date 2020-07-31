package com.boss.springcloud.service.serviceImpl;

import com.boss.springcloud.dao.OrderDao;
import com.boss.springcloud.entity.Order;
import com.boss.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order queryById(int typeid) {
        return orderDao.queryById(typeid);
    }

    @Override
    public List<Order> queryAll() {
        return orderDao.queryAll();
    }
}
