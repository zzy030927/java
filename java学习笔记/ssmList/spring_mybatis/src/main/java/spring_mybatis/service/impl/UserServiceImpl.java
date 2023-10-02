package spring_mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_mybatis.mapper.UserMapper;
import spring_mybatis.pojo.Users;
import spring_mybatis.service.UserService;

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

    @Override
    public void update(String username, String newPassword) {
        userMapper.update(username, newPassword);
    }
}
