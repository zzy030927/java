package com.carProgram.controller;

import com.carProgram.pojo.Result;
import com.carProgram.pojo.Users;
import com.carProgram.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public Result select() {
        List<Users> usersList = userService.select();
        return Result.success(usersList);
    }

    @GetMapping("/user/{username}")
    public Result select(@PathVariable String username) {
        Users user = userService.selectByUser(username);
        return Result.success(user);
    }

    @PutMapping("/user/{newPassword}")
    public Result update(@PathVariable String newPassword, @RequestBody Users user) {
        Users currUser = userService.selectByUser(user.getUsername());
        if (currUser != null && currUser.getPassword().equals(user.getPassword())) {
            userService.update(user.getUsername(), newPassword);
            return Result.success();
        }
        return Result.error("用户名或密码错误");
    }
}
