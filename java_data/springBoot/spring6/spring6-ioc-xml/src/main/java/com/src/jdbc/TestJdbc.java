package com.src.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestJdbc {
    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("../resources/jdbc.properties");
        properties.load(fis);
        String user = properties.getProperty("jdbc.user");
        String url = properties.getProperty("jdbc.url");
        String password = properties.getProperty("jdbc.password");
        String driver = properties.getProperty("jdbc.driver");
        DruidDataSource source = new DruidDataSource();
        source.setUrl(url);
        source.setUsername(user);
        source.setPassword(password);
        source.setDriverClassName(driver);
    }
}
