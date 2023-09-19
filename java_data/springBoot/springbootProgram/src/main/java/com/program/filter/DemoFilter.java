package com.program.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// Filter过滤器，在没有登陆时不能访问其他资源
//@WebFilter(urlPatterns = "/*")  // 拦截所有请求
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {   // 初始化方法，只会被调用一次，该方法有默认值，一般情况下不用被重写
        System.out.println("init 初始化方法执行了");
        Filter.super.init(filterConfig);
    }

    @Override   // 拦截到请求之后调用，会调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DemoFilter 拦截到了请求");
        // 放行操作
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("DemoFilter 放行");
    }

    @Override
    public void destroy() {         // 销毁方法，只会被调用一次，该方法有默认值，一般情况下不用被重写
        System.out.println("destroy 销毁方法执行了");
        Filter.super.destroy();
    }
}
