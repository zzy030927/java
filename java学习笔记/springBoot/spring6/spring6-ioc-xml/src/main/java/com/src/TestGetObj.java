package com.src;

import com.src.bean.UserDao;
import com.src.di.Book;
import com.src.iocxml.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetObj {
    @Test
    public void getUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 根据id获取bean
        User user = (User) context.getBean("user");
        System.out.println(user);
        // 根据类型获取bean
        User user1 = context.getBean(User.class);
        System.out.println(user1);

        User user2 = context.getBean("user", User.class);
        System.out.println(user2);
    }

    @Test
    public void getUserDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        UserDao personDao = (UserDao) context.getBean("personDao");
        System.out.println(userDao);
        System.out.println(personDao);
    }

    @Test
    public void getBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean(Book.class);
        System.out.println(book);
    }

}