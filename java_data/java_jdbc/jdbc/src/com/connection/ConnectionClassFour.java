package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClassFour
{
    public void ConnectionClass4() throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";
        String user = "root";
        String password = "zzy0927";
//      方法四对方法三进行优化，mysql 帮忙注册，不用自己去 registerDriver 注册
//      驱动 Driver接口 中有一个 static 静态代码块，它随着类的加载而执行，这个静态代码块注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
          // 注册驱动
//        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("连接成功四");
        System.out.println(connection);
    }
}
