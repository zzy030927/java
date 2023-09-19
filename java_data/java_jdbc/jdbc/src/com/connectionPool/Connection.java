package com.connectionPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

public class Connection
{
    // 放在方法体外面，多个对象同时调用连接时，不用每次都生成一个对象，并且生成的对象都是一样的。
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("HelloC3p0");  // 封装的 xml文件中 自定义配置名称
    // 新加载方式
    public static java.sql.Connection getConnection() throws Exception
    {
        java.sql.Connection connection = cpds.getConnection();
        return connection;
    }
    // 旧加载方式
    public static java.sql.Connection ConnecionClass5() throws Exception
    {
        // 第五种连接方式
        InputStream is = new FileInputStream("E:\\java\\java_data\\java_jdbc\\jdbc\\src\\com\\connection\\jdbc.properties");
        Properties pro =new Properties();
        pro.load(is);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String driver = pro.getProperty("driver");
        String url = pro.getProperty("url");

        Class.forName(driver);
        java.sql.Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("连接成功五");
        System.out.println(connection);
        return connection;
    }
}
