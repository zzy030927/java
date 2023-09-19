package com.carProgram.service.impl;

import com.carProgram.mapper.UserMapper;
import com.carProgram.pojo.Users;
import com.carProgram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    // 查询所有的用户信息
    @Override
    public List<Users> select() {
        List<Users> usersList = userMapper.select();
        return usersList;
    }

    // 根据用户名查询用户信息
    @Override
    public Users selectByUser(String username) {
        Users user =  userMapper.selectByUser(username);
        return user;
    }

    @Override
    public void update(String username, String newPassword) {
        userMapper.update(username, newPassword);
    }

    @Override
    public Users login(Users users) {
        Users user = userMapper.login(users);
        return user;
    }
}
