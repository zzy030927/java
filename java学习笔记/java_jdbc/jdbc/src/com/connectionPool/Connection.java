package com.connectionPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

public class Connection
{
    // ���ڷ��������棬�������ͬʱ��������ʱ������ÿ�ζ�����һ�����󣬲������ɵĶ�����һ���ġ�
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("HelloC3p0");  // ��װ�� xml�ļ��� �Զ�����������
    // �¼��ط�ʽ
    public static java.sql.Connection getConnection() throws Exception
    {
        java.sql.Connection connection = cpds.getConnection();
        return connection;
    }
    // �ɼ��ط�ʽ
    public static java.sql.Connection ConnecionClass5() throws Exception
    {
        // ���������ӷ�ʽ
        InputStream is = new FileInputStream("E:\\java\\java_data\\java_jdbc\\jdbc\\src\\com\\connection\\jdbc.properties");
        Properties pro =new Properties();
        pro.load(is);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String driver = pro.getProperty("driver");
        String url = pro.getProperty("url");

        Class.forName(driver);
        java.sql.Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("���ӳɹ���");
        System.out.println(connection);
        return connection;
    }
}
