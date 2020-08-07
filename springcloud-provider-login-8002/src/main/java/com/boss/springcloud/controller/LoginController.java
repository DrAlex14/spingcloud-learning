package com.boss.springcloud.controller;


import com.boss.springcloud.entity.vo.UserVo;
import com.boss.springcloud.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static com.boss.springcloud.utils.DesUtil.getEncryptString;

@Controller
@RequestMapping("/user")
@Log4j2
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login/{username}/{password}")
    @ResponseBody
    public String login(@PathVariable("username") String username, @PathVariable("password") String password, HttpServletRequest request, HttpServletResponse response){
        String des_password; //加密后的用户名密码

        log.info(password);

        des_password = getEncryptString(password);//对密码加密

        log.info(username);
        log.info(des_password);

        UserVo realuser = new UserVo();
        BeanUtils.copyProperties(loginService.queryForUser(username,des_password),realuser);
        log.info("角色:"+ realuser.getRole());

        /**
         * 试验Cookie共享用户信息
         */
        Cookie usernamecookie = new Cookie("username",realuser.getUsername());
        if(realuser.getRole() == 1) {
            Cookie rolecookie = new Cookie("role","admin");
            rolecookie.setPath("/");
            response.addCookie(rolecookie);
        }else if(realuser.getRole() == 2){
            Cookie rolecookie = new Cookie("role","check");
            rolecookie.setPath("/");
            response.addCookie(rolecookie);
        }
        usernamecookie.setPath("/");
        response.addCookie(usernamecookie);


        if(realuser != null)
        {
            //未来使用redis保存
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("role",realuser.getRole());

            log.info(session.getAttribute("username"));
            log.info(session.getAttribute("role"));
            return "登录成功";
        }
        return "登录失败";
    }
}
