package com.boss.springcloud.dao;

import com.boss.springcloud.entity.po.OrderPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface OrderDao {

    OrderPo queryById(int typeid);

    List<OrderPo> queryAll();

    void delete(int typeid);

    void update(int typeid,int num);

    void add(String name,int typeid,int num);
}
