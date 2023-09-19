package com.connection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
//测试连接数据库

public class ConnectionClass
{
    @Test
    public void ConnectionClass1() throws SQLException
    {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        //      Driver 接口用于连接数据库，创建一个mysql驱动对象，并把它赋值给 driver
        //	    注意要写新的驱动地址，不要写成 com.mysql.jdbc.Driver(),这是5.0版本的驱动地址;
        //      Driver 连接数据库接口的对象，对这个对象进行实例化
        //      idea : Ctrl + H 查看实现类

        String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";

        //      URL 为 要连接哪个数据库, 意义为 用 jdbc链接 mysql 数据库，连接的主机（ip）是localhost
        //      端口号是 3306，链接的表是 localhost 中的 test 数据库
        //      参数和路径用 ? 隔开。
        //      useUnicode = true&characterEncoding = utf-8 作用是设置编码解码格式
        //      useSSL = false; 网址:https://blog.csdn.net/weixin_46644575/article/details/117003617?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167973667916800197064678%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=167973667916800197064678&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-117003617-null-null.142^v76^insert_down38,201^v4^add_ask,239^v2^insert_chatgpt&utm_term=usessl%3Dfalse&spm=1018.2226.3001.4187
        //      allowPublicKeyRetrieval = true 允许客户端从服务器获取公钥。
        //      serverTimezone = UTC，无论是使用5.#数据库还是8.#版本数据库，
        //      只要jdbc驱动使用的是8.#那么我们就需要考虑数据库时区问题，否则就会报时区错误
        //      所以要加 serverTimezone = GMT,这是设置时区的作用

        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","zzy0927");
        //      将用户名和密码封装在 Properties中

        Connection connection = driver.connect(url,info);
        //      Driver 接口中的 connect 方法，用于连接数据库，
        //      里面的两个参数 String类型的 url 与 Properties类型的 info
        //      并且把这个连接完成的数据给 Connection 对象。

        System.out.println("链接成功");
        System.out.println(connection);
    }
}
