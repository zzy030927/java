package com.program.aop;

import com.alibaba.fastjson.JSONObject;
import com.program.mapper.OperateLogMapper;
import com.program.pojo.OperateLog;
import com.program.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
@Slf4j      // 切面类
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper logMapper;

    @Around("@annotation(com.program.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        // 获取操作人的id
            // 获取请求头中的jwt令牌，解析令牌
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        // 操作类名
        String className = joinPoint.getTarget().getClass().getName();

        // 操作方法名
        String methodName = joinPoint.getSignature().getName();

        // 操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

            // 获取方法开始执行时间
        long startTime = System.currentTimeMillis();

        // 调用原始方法运行
        Object res = joinPoint.proceed();

            // 获取方法结束时间
        long endTime = System.currentTimeMillis();

        // 方法返回值
        String returnValue = JSONObject.toJSONString(res);      // 将一个json格式的对象转换成string类型的字符串

        // 操作耗时
        Long costTime = endTime - startTime;

        // 记录日志操作
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        logMapper.insert(operateLog);
        log.info("AOP记录操作日志：{}", operateLog);
        return res;
    }
}
