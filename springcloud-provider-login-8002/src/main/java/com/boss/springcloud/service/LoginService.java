package com.boss.springcloud.service;

import com.boss.springcloud.entity.dto.UserDto;

public interface LoginService {

    UserDto queryForUser(String username, String password);
}
