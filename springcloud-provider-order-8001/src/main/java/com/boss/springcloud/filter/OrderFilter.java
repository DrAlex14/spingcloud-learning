package com.boss.springcloud.filter;

import lombok.extern.log4j.Log4j2;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(filterName = "OrderFilter",urlPatterns = "/order/admin/*")
public class OrderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      log.info("filter拦截");

        /**
         * 试验cookie共享
         */
        String role = null;
        Cookie[] list = ((HttpServletRequest) request).getCookies();
        log.info(list);
        if(list != null){
            for(Cookie cookie : list){
                if(cookie.getName().equals("role")){
                    role = cookie.getValue();
                    break;
                }
            }
        }
        log.info(role);
        if(role.equals("admin")){
            chain.doFilter(request,response);
        }
        log.info("权限不足");
    }

    @Override
    public void destroy() {

    }
}
