package com.boss.springcloud.dao;

import com.boss.springcloud.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {

    public User queryForUser(String username,String password);
}
