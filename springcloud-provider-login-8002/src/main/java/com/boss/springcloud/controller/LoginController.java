package com.boss.springcloud.controller;

import com.boss.springcloud.entity.User;
import com.boss.springcloud.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.boss.springcloud.utils.DesUtil.getEncryptString;

@Controller
@RequestMapping("/user")
@Log4j2
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login/{username}/{password}")
    @ResponseBody
    public String login(@PathVariable("username") String username,@PathVariable("password") String password){
        String des_username,des_password; //加密后的用户名密码
        log.info(username);
        log.info(password);

        des_username = getEncryptString(username);//对用户名加密
        des_password = getEncryptString(password);//对密码加密

        log.info(des_username);
        log.info(des_password);

        User realuser = loginService.queryForUser(des_username,des_password);
        if(realuser != null) return "登录成功";
        return "登录失败";
    }
}
