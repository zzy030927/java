package spring_mybatis.service;

import spring_mybatis.pojo.Users;

import java.util.List;

public interface UserService {
    List<Users> select();

    void update(String username, String newPassword);

}
