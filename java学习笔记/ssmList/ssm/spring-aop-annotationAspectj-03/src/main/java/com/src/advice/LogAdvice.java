package com.src.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 增强类
/*
*   1. 定义增强方法
*       具体定义几个方法，根据插入位置决定。
*   2. 使用注解配置，加对应注解使得插入目标方法的位置
*       前置 @Before
*       后置 @AfterReturning
*       异常 @AfterThrowing，在 catch() {} 中使用
*       最后 @After
*       环绕 @Around
*    3. 配置切入点表达式：即选择要插入的方法，即选择切点
*
*    4. 补全注解
*        加入ioc容器 @Component
*        配置切面 @Aspect
*
*    5. 开启aspect注解支持
*        可以在配置文件和配置类中配置
*        配置文件：<aop:aspectj-autoproxy/>
*        配置类：@EnableAspectJAutoProxy
* */
@Component
@Aspect     // 此注解表示LogAdvice为切面类
public class LogAdvice {

    @Before("execution(* com.src.service.impl.*.*(..))")
    public void pre() {
        System.out.println("方法开始执行");
    }

    @After("execution(* com.src.service.impl.*.*(..))")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* com.src.service.impl.*.*(..))")
    public void error() {
        System.out.println("方法报错了");
    }
}
