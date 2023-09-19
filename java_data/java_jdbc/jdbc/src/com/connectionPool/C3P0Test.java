package com.connectionPool;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import java.sql.Connection;

// 测试连接池  C3P0
public class C3P0Test
{
    // 方式一：暴露 url,user,password,驱动
    @Test
    public void testGetConnection1() throws Exception
    {
        ComboPooledDataSource cpds = new ComboPooledDataSource();   // 生成一个数据库连接池对象
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&rewriteBitchedStatements=true");
        cpds.setUser("root");
        cpds.setPassword("zzy0927");
        cpds.setInitialPoolSize(10);    // 设置初始时数据库连接池中数量为 10 个
        Connection connection = cpds.getConnection();
        System.out.println(connection);
        // 连接池一般情况下不关闭，只收回对外放出去的连接
    }
    // 方式 2：封装
    @Test
    public Connection testGetConnection2() throws Exception {
        // 将 驱动地址、url、用户名、密码封装在 xml 文件内,且这个文件名字、内容是按照 c3p0定义写的
        ComboPooledDataSource cpds = new ComboPooledDataSource("HelloC3p0");  // 封装的 xml文件中 自定义配置名称
        Connection connection = cpds.getConnection();
        System.out.println(connection);
        return connection;
    }
}
