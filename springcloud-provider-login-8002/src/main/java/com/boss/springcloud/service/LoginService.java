package com.boss.springcloud.service;

import com.boss.springcloud.entity.User;

public interface LoginService {

    public User queryForUser(String username,String password);
}
