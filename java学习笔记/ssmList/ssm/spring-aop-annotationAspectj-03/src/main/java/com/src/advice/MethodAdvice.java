package com.src.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/*
* 在此类中获取目标方法的全部信息，包括获取方法名，参数，访问修饰符，或者所属的类的信息
* 获取返回结果，只在afterReturning中有效
* 获取异常信息，只在afterThrowing中有效
*   */
@Aspect
@Component
public class MethodAdvice {

    // 目标执行前
    @Before("execution(* com.src.service.impl.*.*(..))")
    public void before(JoinPoint joinPoint) {   // JointPoint 为目标方法类的封装对象
        // 1.获取方法所属类的信息 - jointPoint.getTarget()获取目标类，之后反射
        String className = joinPoint.getTarget().getClass().getSimpleName();
        // 2.获取目标方法名称 joinPoint.getSignature() 获取方法的详细信息
        String methodName = joinPoint.getSignature().getName();
        // 3.获取参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("className = "+className+ " methodName = " + methodName + " args =" + Arrays.toString(args));
    }

    // 目标正常执行完毕后执行
    @AfterReturning(value = "execution(* com.src.service.impl.*.*(..))", returning = "res")
    public void afterReturning(JoinPoint joinPoint, Object res) {    // res用于接受返回值
        System.out.println("返回的结果为: " + res);
    }

    // 最后目标报不报错都会执行
    @After("execution(* com.src.service.impl.*.*(..))")
    public void after(JoinPoint joinPoint) {

    }

    // 目标执行时报错
    @AfterThrowing(value = "execution(* com.src.service.impl.*.*(..))", throwing = "e")
    public void error(JoinPoint joinPoint, Throwable e) {       // Throwable用于接受异常信息
//        System.out.println(e.getMessage());
    }
}
