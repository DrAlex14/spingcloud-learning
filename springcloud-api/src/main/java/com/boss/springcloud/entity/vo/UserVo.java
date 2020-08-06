package com.boss.springcloud.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class UserVo {
    private String username;

    private String password;

    private int role;  //1为管理员,可以增删改查；2为审核，只能查看
}
