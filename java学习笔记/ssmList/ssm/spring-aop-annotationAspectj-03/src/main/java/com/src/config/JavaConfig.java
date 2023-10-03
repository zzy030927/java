package com.src.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.src")
@EnableAspectJAutoProxy // 开启Aspectj注解
public class JavaConfig {
}
