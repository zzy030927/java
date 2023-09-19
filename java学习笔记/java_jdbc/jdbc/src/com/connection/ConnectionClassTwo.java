package com.connection;
import javax.xml.transform.stream.StreamSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionClassTwo
{
    public void ConnectionClass2() throws Exception
    {
        // 1.用反射方式接受驱动地址并且获取 Driver类对象
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","zzy0927");
        Connection connection = driver.connect(url, info);
        System.out.println("连接成功二");
        System.out.println(connection);
        
    }
}
