package spring_mybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_mybatis.pojo.Users;
import spring_mybatis.service.UserService;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public void select() {
        List<Users> usersList = userService.select();
        for (Users users : usersList) {
            System.out.println(users);
        }
    }

}
