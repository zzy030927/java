package com.carProgram.service;

import com.carProgram.pojo.Users;

import java.util.List;

public interface UserService {
    List<Users> select();

    Users selectByUser(String username);

    void update(String username, String newPassword);

    Users login(Users user);
}
