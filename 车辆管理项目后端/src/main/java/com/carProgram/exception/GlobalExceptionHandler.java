package com.carProgram.exception;

import com.carProgram.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice       // 全局异常处理器
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)      // 定义捕获哪一类型的异常
    public Result ex(Exception ex) {
        ex.printStackTrace();
        return Result.error("数据库操作失败，联系我");
    }
}
