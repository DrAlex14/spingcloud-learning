package com.boss.springcloud.filter;

import lombok.extern.log4j.Log4j2;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        int userrole = (int)session.getAttribute("role");
        int role = 1;
        if(0 != userrole){
            role = userrole;
        }
        if(role < 2){  //为管理员
            chain.doFilter(request,response);
        }
      log.info("权限不足");
    }

    @Override
    public void destroy() {

    }
}
