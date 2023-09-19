package com.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionClassThree
{
    public void ConnectionClass3() throws Exception
    {
        // 使用 DriverManager类 替代 Driver

        // 用反射获取 Driver 的实现类对象
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";
        String user = "root";
        String password = "zzy0927";
        // DriverManager类中有一个 registerDriver方法用于注册驱动
        DriverManager.registerDriver(driver);
        // DriverManager类中有一个 getConnection方法获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("连接成功三");
        System.out.println(connection);

    }
}