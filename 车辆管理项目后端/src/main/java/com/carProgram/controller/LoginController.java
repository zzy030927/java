package com.carProgram.controller;

import com.carProgram.pojo.Result;
import com.carProgram.pojo.Users;
import com.carProgram.service.UserService;
import com.carProgram.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody Users user) {
        Users login = userService.login(user);
        if (login != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", login.getUsername());
            claims.put("password", login.getPassword());
            claims.put("sign", login.getSign());
            String jwt = JwtUtils.generateJwt(claims);  // 生成jwt令牌，jwt中已经包含登录员工的信息
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
