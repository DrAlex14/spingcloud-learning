package com.boss.springcloud.service.serviceimpl;

import com.boss.springcloud.dao.LoginDao;
import com.boss.springcloud.entity.User;
import com.boss.springcloud.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public User queryForUser(String username,String password) {
        return loginDao.queryForUser(username,password);
    }
}
