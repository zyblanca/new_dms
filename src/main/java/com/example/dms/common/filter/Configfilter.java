package com.example.dms.common.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhouy
 * @date 2021/9/23
 * good 09
 */
@Component
@WebFilter(urlPatterns={"/*"})
public class Configfilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest Request = (HttpServletRequest) servletRequest;
        if (Request.getRequestURI().indexOf("good") == -1){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

    }

    @Override
    public void destroy() {
        System.out.println("拦截器销毁");
    }
}
