package com.boss.springcloud.dao;

import com.boss.springcloud.entity.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {

    UserDto queryForUser(String username, String password);
}
