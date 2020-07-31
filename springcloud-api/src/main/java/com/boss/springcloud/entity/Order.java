package com.boss.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Order implements Serializable {
    private String name;
    private int typeid;
    private int num;

    private String db_source;//数据所在数据库

    public Order(String name, int typeid, int num) {
        this.name = name;
        this.typeid = typeid;
        this.num = num;
    }
}
