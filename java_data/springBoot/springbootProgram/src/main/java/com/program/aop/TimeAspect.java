package com.program.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// AOP：面向切面编程，利用了动态代理的原理
@Component
//@Aspect         // AOP 注解
@Slf4j
public class TimeAspect {

    //@Around注解 声明调用哪些原始方法
    //第一个*代表返回值任意
    //之后声明方法的位置
    //第二个*代表任意类或接口
    //第二个*代表任意方法
    //(..)为方法的参数
    @Pointcut("execution(* com.program.service.*.*(..))")       // 抽取切入点表达式
    private void pt(){}     // private 仅在当前切面类中可以引用该切面表达式，public为可以在其他切面类中引用该切面表达式

    @Around("pt()")     // 引用
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {  // 记录程序运行时间
        // 1.记录开始时间
        long startTime = System.currentTimeMillis();
        // 2.调用原始方法运行
        Object result = joinPoint.proceed();    // 原始方法的返回值
        // 3.记录结束时间
        long endTime = System.currentTimeMillis();
        log.info("方法执行时间为: " + (endTime - startTime));
        return result;
    }
}
