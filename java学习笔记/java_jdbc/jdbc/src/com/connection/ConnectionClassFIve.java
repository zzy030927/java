package com.connection;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

// 返回一个连接数据库的实例
public class ConnectionClassFIve
{
    public static Connection ConnecionClass5() throws Exception
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
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("连接成功五");
        System.out.println(connection);
        return connection;
    }
}
