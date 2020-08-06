package com.boss.springcloud.service.serviceimpl;

import com.boss.springcloud.dao.LoginDao;
import com.boss.springcloud.entity.dto.UserDto;
import com.boss.springcloud.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public UserDto queryForUser(String username, String password) {
        UserDto userDto = loginDao.queryForUser(username,password);
        return userDto;
    }
}
