package com.connectionPool;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DbcpTest
{
    @Test
    // ���� DBCP ���ݿ����ӳؼ���
    public void getDbcpGetConnection1() throws Exception
    {
        // ������ dbcp �����ݿ����ӳ�
        BasicDataSource bds = new BasicDataSource();
        // ���û�����Ϣ
        bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&rewriteBitchedStatements=true");
        bds.setUsername("root");
        bds.setPassword("zzy0927");
        // �������������ݿ����ӳع�����������
        // �ο� dbcp.txt
        bds.setInitialSize(10);
        bds.setMaxActive(50);
        Connection connection = bds.getConnection();
        System.out.println(connection);
    }

    private static DataSource source;
    static  // ��̬����飬������ļ��ض����أ�ִֻ��һ��
    {
        try{
            Properties pros = new Properties();
            InputStream is = new FileInputStream("jdbc/src/com/connectionPool/dbcp.properties");
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public Connection getDbcpGetConnection2() throws Exception
    {
        Connection connection = source.getConnection();
        System.out.println(connection);
        return connection;
    }
}
