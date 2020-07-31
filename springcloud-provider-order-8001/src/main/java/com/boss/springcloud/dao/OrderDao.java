package com.boss.springcloud.dao;

import com.boss.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface OrderDao {

    public Order queryById(int typeid);

    public List<Order> queryAll();
}
