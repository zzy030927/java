package com.program.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 过滤器链，AbcFilter过滤器拦截后进行放行，再轮到DemoFilter过滤器拦截进行放行
// 拦截顺序为 类首字母靠前的先拦截
//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AbcFilter 拦截器拦截");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("AbcFilter 放行");
    }
}
