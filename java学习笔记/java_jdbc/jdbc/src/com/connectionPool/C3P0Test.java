package com.connectionPool;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import java.sql.Connection;

// �������ӳ�  C3P0
public class C3P0Test
{
    // ��ʽһ����¶ url,user,password,����
    @Test
    public void testGetConnection1() throws Exception
    {
        ComboPooledDataSource cpds = new ComboPooledDataSource();   // ����һ�����ݿ����ӳض���
        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&rewriteBitchedStatements=true");
        cpds.setUser("root");
        cpds.setPassword("zzy0927");
        cpds.setInitialPoolSize(10);    // ���ó�ʼʱ���ݿ����ӳ�������Ϊ 10 ��
        Connection connection = cpds.getConnection();
        System.out.println(connection);
        // ���ӳ�һ������²��رգ�ֻ�ջض���ų�ȥ������
    }
    // ��ʽ 2����װ
    @Test
    public Connection testGetConnection2() throws Exception {
        // �� ������ַ��url���û����������װ�� xml �ļ���,������ļ����֡������ǰ��� c3p0����д��
        ComboPooledDataSource cpds = new ComboPooledDataSource("HelloC3p0");  // ��װ�� xml�ļ��� �Զ�����������
        Connection connection = cpds.getConnection();
        System.out.println(connection);
        return connection;
    }
}
