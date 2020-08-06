package com.boss.springcloud.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class OrderDto  implements Serializable {
    private String name;

    private int typeid;

    private int num;

    public OrderDto(String name, int typeid, int num) {
        this.name = name;
        this.typeid = typeid;
        this.num = num;
    }

}
