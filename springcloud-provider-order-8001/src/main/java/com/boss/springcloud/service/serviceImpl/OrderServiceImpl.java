package com.boss.springcloud.service.serviceImpl;

import com.boss.springcloud.dao.OrderDao;
import com.boss.springcloud.entity.dto.OrderDto;
import com.boss.springcloud.entity.po.OrderPo;
import com.boss.springcloud.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public OrderDto queryById(int typeid) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderDao.queryById(typeid),orderDto);
        return orderDto;
    }

    @Override
    public List<OrderDto> queryAll() {
        List<OrderDto> listDto = new ArrayList<OrderDto>();
        List<OrderPo> listPos = orderDao.queryAll();

        log.info((CollectionUtils.isEmpty(listPos)));

        if(!CollectionUtils.isEmpty(listPos)){
            for (OrderPo orderPo : listPos) {
                OrderDto orderDto=new OrderDto();
                BeanUtils.copyProperties(orderPo,orderDto );
                listDto.add(orderDto);
            }
        }
        return listDto;
    }

    @Override
    public void delete(int typeid) {
        orderDao.delete(typeid);
    }

    @Override
    public void update(int typeid,int num) {
        orderDao.update(typeid,num);
    }

    @Override
    public void add(String name, int typeid, int num) {
        orderDao.add(name, typeid, num);
    }


}
