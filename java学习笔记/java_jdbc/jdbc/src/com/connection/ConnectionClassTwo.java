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
        // 1.�÷��䷽ʽ����������ַ���һ�ȡ Driver�����
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.�ṩҪ���ӵ����ݿ�
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","zzy0927");
        Connection connection = driver.connect(url, info);
        System.out.println("���ӳɹ���");
        System.out.println(connection);
        
    }
}
