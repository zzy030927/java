package com.program.config;

import com.program.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {    // 配置类

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;    // 将拦截器注入进来
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)  // 添加拦截器
                .addPathPatterns("/**")                 // 添加要拦截的资源
                .excludePathPatterns("/login");         // 不需要拦截的资源
    }
}
