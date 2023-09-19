package com.connectionPool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidTest
{
    private static DataSource source;
    static{
        try {
            Properties pros = new Properties();
            InputStream is = new FileInputStream("jdbc/src/com/connectionPool/druid.properties");
            pros.load(is);
            source = DruidDataSourceFactory.createDataSource(pros);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public static Connection getDruidConnection() throws Exception
    {
        Connection connection = source.getConnection();
        System.out.println(connection);
        return connection;
    }
}
