package com.boss.springcloud.entity;

import com.boss.springcloud.entity.po.UserPo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)//链式写法
public class User{
    private String username;

    private String password;
}
