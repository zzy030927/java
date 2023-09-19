package com.program.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.program.pojo.Result;
import com.program.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HandlerInterceptor 拦截器
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override   // 目标资源方法运行前运行，返回值如果为true代表放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.获取请求的URL
        String url = request.getRequestURI();
        log.info("请求的url:" + url);
        // 2.判断请求的url中是否包含login,如果包含,说明是登陆操作,放行。
        if(url.contains("login")) {
            log.info("登陆操作");
            return true;
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
            return false;
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
            return false;
        }
        // 6.放行
        log.info("令牌合法，放行");
        return true;
    }

    @Override   // 目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override   // 视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
