package com.peng.ajaxserver;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by PengHongfu 2018-06-22 16:25
 */
public class CrosFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String origin = req.getHeader("Origin");
        String headers = req.getHeader("Access-Control-Request-Headers");
        //支持所有跨域地址
        if(!StringUtils.isEmpty(origin)){
            res.addHeader("Access-Control-Allow-Origin",origin);
        }

        //支持所有跨域请求头
        if(!StringUtils.isEmpty(headers)){
            res.addHeader("Access-Control-Allow-Headers",headers);
        }

        //* 带cookie时，origin必须全匹配，不能使用* 并且要使用Allow-Credentials 为true
        //res.addHeader("Access-Control-Allow-Origin","http://localhost:8081");
        res.addHeader("Access-Control-Allow-Methods","*");
        //res.addHeader("Access-Control-Allow-Headers","Content-Type");

        //res.addHeader("Access-Control-Allow-Headers","Content-Type,x-header1,x-header2");

        res.addHeader("Access-Control-Max-Age","3600");//预检命令缓存
        //enable cookie
        res.addHeader("Access-Control-Allow-Credentials","true");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
