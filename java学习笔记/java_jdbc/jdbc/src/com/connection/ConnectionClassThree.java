package com.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionClassThree
{
    public void ConnectionClass3() throws Exception
    {
        // ʹ�� DriverManager�� ��� Driver

        // �÷����ȡ Driver ��ʵ�������
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";
        String user = "root";
        String password = "zzy0927";
        // DriverManager������һ�� registerDriver��������ע������
        DriverManager.registerDriver(driver);
        // DriverManager������һ�� getConnection������ȡ����
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("���ӳɹ���");
        System.out.println(connection);

    }
}