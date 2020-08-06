package com.boss.springcloud.controller;

import com.boss.springcloud.entity.dto.OrderDto;
import com.boss.springcloud.entity.vo.OrderVo;
import com.boss.springcloud.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@Log4j2
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/query/{typeid}")
    public OrderVo queryById(@PathVariable("typeid") int typeid){
        OrderVo orderVo = new OrderVo();
        BeanUtils.copyProperties(orderService.queryById(typeid),orderVo);
        return orderVo;
    }

    @GetMapping("/order/list")
    public List<OrderVo> queryAll(){
        List<OrderVo> listVo = new ArrayList<OrderVo>();
        List<OrderDto> listDtos = orderService.queryAll();

        if(!CollectionUtils.isEmpty(listDtos)){
            for (OrderDto orderDto : listDtos) {
                OrderVo orderVo=new OrderVo();
                BeanUtils.copyProperties(orderDto,orderVo );
                listVo.add(orderVo);
            }
        }
        return listVo;
    }

    @GetMapping("/order/admin/delete/{typeid}")
    public String delete(@PathVariable("typeid") int typeid){
        orderService.delete(typeid);
        return "success";
    }

    @GetMapping("/order/admin/update/{typeid}/{num}")
    public String update(@PathVariable("typeid")int typeid,@PathVariable("num") int num){
        orderService.update(typeid,num);
        return "success";
    }

    @GetMapping("/order/admin/add/{name}/{typeid}/{num}")
    public String add(@PathVariable("name")String name,@PathVariable("typeid") int typeid,@PathVariable("num") int num){
        orderService.add(name,typeid,num);
        return "success";
    }

}
