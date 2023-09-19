package com.program.filter;

import com.alibaba.fastjson.JSONObject;
import com.program.pojo.Result;
import com.program.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;   // 强转
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 1.获取请求的URL
        String url = request.getRequestURI();
        log.info("请求的url:" + url);
        // 2.判断请求的url中是否包含login,如果包含,说明是登陆操作,放行。
        if(url.contains("login")) {
            log.info("登陆操作");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 3.获取请求头中的令牌（token）
        String jwt = request.getHeader("token");
        // 4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if (!StringUtils.hasLength(jwt)) {  // 判断字符串是否有长度
            log.info("请求头token为空");
            Result error = Result.error("NOT_LOGIN");
            // 将对象转换为json格式的数据
            String notLogin = JSONObject.toJSONString(error);   // 将Result对象转换为JSON格式的字符串
            response.getWriter().write(notLogin);   // 返回错误信息给前端
            return;
        }
        // 5.令牌存在，解析jwt令牌，若解析失败，返回错误结果
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) { // jwt 解析失败
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录的错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }
        // 6.放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
