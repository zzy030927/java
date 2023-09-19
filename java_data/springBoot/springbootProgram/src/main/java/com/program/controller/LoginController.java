package com.program.controller;

import com.program.pojo.Login;
import com.program.pojo.Result;
import com.program.service.EmpService;
import com.program.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    private EmpService empService;

    // 验证登录
    @PostMapping("/login")
    public Result login(@RequestBody Login login) {
        log.info("登录验证");
        Login logRes = empService.login(login);
        // 登陆成功，生成令牌，下发令牌
        if(logRes != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", logRes.getUsername());
            claims.put("password", logRes.getPassword());
            String jwt = JwtUtils.generateJwt(claims);  // 生成jwt令牌，jwt中已经包含登录员工的信息
            return Result.success(jwt);
        }
        // 登陆失败，返回错误信息
        return Result.error("用户名或密码错误");
    }

}
