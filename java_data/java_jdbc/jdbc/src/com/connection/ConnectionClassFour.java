package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClassFour
{
    public void ConnectionClass4() throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";
        String user = "root";
        String password = "zzy0927";
//      �����ĶԷ����������Ż���mysql ��æע�ᣬ�����Լ�ȥ registerDriver ע��
//      ���� Driver�ӿ� ����һ�� static ��̬����飬��������ļ��ض�ִ�У������̬�����ע������
        Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
          // ע������
//        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("���ӳɹ���");
        System.out.println(connection);
    }
}
