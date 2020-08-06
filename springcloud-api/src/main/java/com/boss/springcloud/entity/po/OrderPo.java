package com.boss.springcloud.entity.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class OrderPo  implements Serializable{
    private String name;

    private int typeid;

    private int num;

    private String db_source;//数据所在数据库

}
