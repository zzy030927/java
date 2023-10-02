package spring_mybatis;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring_mybatis.controller.UserController;

@SpringBootApplication
public class springMybatisApplication {

    public static void main(String[] args) {
        UserController uc = new UserController();
        uc.select();
    }
}