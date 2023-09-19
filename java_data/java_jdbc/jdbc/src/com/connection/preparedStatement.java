package com.connection;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;
/*
 * ʹ�� PreparedStatement ���滻 Statement,ʵ�ֶ����ݱ����ɾ�Ĳ����
 */

public class preparedStatement
{
    public static void InsertSQL(Connection connection, PreparedStatement ps) throws Exception {
        //value(?,?,?) ?����һ��ռλ��
        String sql = "INSERT INTO customers(name,email,birth) values(?,?,?)";

        //Ԥ����SQL��䣬����һ�� PreparedStatement ��ʵ��
        ps = connection.prepareStatement(sql);

        //���ռλ��
        ps.setString(1,"��");
        ps.setString(2,"ji@gmail.com");
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-DD");
//      �����ڽ��и�ʽ�� y Ϊ year��λ����, M Ϊ month��λ����, DΪ day ��λ����
        java.util.Date date = sdf.parse("1998-08-02");
//      SimpleDateFormat.parse()���ڽ�������ض��ַ���ת���� Date��Ķ���
        ps.setDate(3, new Date(date.getTime()));

        //ִ�� SQL����
        ps.execute();
        System.out.println("����ɹ�");

//      ����һ�� PreparedStatement ʵ���������ر�����
        close.closeResource(connection, ps);
    }
    public static void UpdateSQL(Connection connection, PreparedStatement ps) throws Exception {
        // Alter �������޸ı�

        // connection �Ѿ���ȡ���ݿ�����

        // Ԥ����SQL���
        String sql = "UPDATE customers SET name = ? WHERE id = ?";
        ps = connection.prepareStatement(sql);

        // ���ռλ��
        ps.setString(1, "Ī����");
        ps.setInt(2, 18);

        // �ύ����
        ps.execute();
        System.out.println("�����޸ĳɹ�");

        // �ر�����
        close.closeResource(connection, ps);
    }
    public static void DeleteSQL(Connection connection, PreparedStatement ps) throws Exception {
        // Delete ɾ�������

        // 1. ��ȡ����
        // 2. Ԥ����SQL���
        String sql = "DELETE FROM customers WHERE id = ?";
        ps = connection.prepareStatement(sql);

        // 3.���ռλ��
        ps.setInt(1, 33);

        //4.�ύ����
        ps.execute();
        System.out.println("ɾ���ɹ�");

        close.closeResource(connection, ps);
    }
    public static void UniverseOperation(Connection connection, PreparedStatement ps, String sql, Object ...args) throws Exception{
        // ͨ�õ���ɾ�Ĳ���
        // Object ...args Ϊ�ɱ��βΣ������м��������Ϳ����˼�������������Ϊ ������ĸ��� Object

        // 1.�������ݿ�

        // 2.Ԥ����
        ps = connection.prepareStatement(sql);

        // 3.���ռλ��
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i + 1, args[i]);
            // ע�⣺ռλ�����Ǵ� 1��ʼ�ģ����� i Ҫ�� 1
        }

        // 4.�ύ����
        ps.execute();
        System.out.println("��ɲ���");
        close.closeResource(connection, ps);
    }
    public static void SelectSQL(Connection connection, PreparedStatement ps, ResultSet resultSet) throws Exception {
        // 1.���ݿ�����
        // 2.Ԥ����
        String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
        ps = connection.prepareStatement(sql);

        // 3.����ַ�
        ps.setInt(1, 1);

        // 4.�ύ����,����һ�������
        // PreparedStatement �ӿ�����һ������ executeQuery()��execute:ִ�У�Query:��ѯ��������һ�������
        resultSet = ps.executeQuery();
        // next()�ж��Ƿ�����һ�����ݣ���������ݷ��� true,ָ��ָ����һ������
        if(resultSet.next())
        {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Date birth = resultSet.getDate(4);

            Customer customer = new Customer(id, name, email, birth);
            // ���������ݷ�װ��һ�����У���������Լ������
            System.out.println(customer.toString());
        }
        System.out.println("���ҳɹ�");

        close.closeResource(connection, ps, resultSet);
    }
    public static Customer UniverseSpecificSelectSQL(Connection connection, PreparedStatement ps, ResultSet resultSet, String sql, Object ...args) throws Exception {
        //��ȡ���ݿ�����
        //Ԥ����
        ps = connection.prepareStatement(sql);
        //���ռλ��
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i+1, args[i]);
        }

        resultSet = ps.executeQuery();
        //��ȡ�������Ԫ���ݣ�ResultSetMetaData
        ResultSetMetaData rsmd = resultSet.getMetaData();
        //��ȡԪ���ݵ�������Ҳ���ǻ�ȡ����� sql ��Ҫ��ѯ����
        int columnCount = rsmd.getColumnCount();
        if(resultSet.next())
        {
            Customer customer = new Customer();
            // ���������е�ÿһ��
            for(int i = 0; i < columnCount; i++)
            {
                // ��ȡ������е�һ���ֶε�ֵ
                Object columnValue = resultSet.getObject(i + 1);
                // ��Ԫ���� rsmd ��ȡ����ֶε�����
                String columnName = rsmd.getColumnName(i + 1);

                // ͨ������ �ҵ� customer ������ columnName ��ͬ������ �������� columnValue ��ֵ ��ֵ�� �������
                Field field = Customer.class.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(customer, columnValue);

            }
            System.out.println(customer.toString());
        }
        return null;
    }
    public static <T>T UniverseSelectSQL(Class<T> clazz, String sql, Object ...args) throws Exception {
        // ʹ�� PreparedStatement ʵ����Բ�ͬ��Ĳ�ѯ����

        // 1.��ȡ����
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = ConnectionClassFIve.ConnecionClass5();

        //Ԥ����
        PreparedStatement ps = connection.prepareStatement(sql);
        //���ռλ��
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i + 1, args[i]);
        }

        // �ύ���ݲ����ؽ����
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        if(rs.next())
        {
            T t = clazz.getConstructor().newInstance();
            // ���κ�һ�����ṩһ���ղε� public Ȩ�޵Ĺ�����
            for(int i = 0; i < columnCount; i++)
            {
                String columnName = rsmd.getColumnLabel(i+1);
                Object columnValue = rs.getObject(i+1);
                Field field = clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t, columnValue);
            }
            System.out.println(t);
            close.closeResource(connection, ps, rs);
            return t;
        }
        close.closeResource(connection, ps, rs);
        return null;
    }
    public static <T> List<T> SelectManyResult(Class<T> clazz, String sql, Object ...args) throws Exception     {
        // ��ѯ������¼������
        // 1.��ȡ����
        Connection connection = ConnectionClassFIve.ConnecionClass5();

        // 2.Ԥ����
        PreparedStatement ps = connection.prepareStatement(sql);
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i+1, args[i]);
        }

        // 3.�ύ���ݲ����ؽ��
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        ArrayList<T> list = new ArrayList<T>();
        while(rs.next())
        {
            T t = clazz.getConstructor().newInstance();
            for(int i = 0; i < columnCount; i++)
            {
                String columnName = rsmd.getColumnLabel(i+1);
                Object columnValue = rs.getObject(i+1);
                Field field =  clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t, columnValue);
            }
            System.out.println(t);
            list.add(t);
        }
        close.closeResource(connection, ps, rs);
        return list;
    }
    public static void InsertBlob(Connection connection, PreparedStatement ps) throws Exception {
        // �����ݱ��в��� blob ���͵��ֶ�
        connection = ConnectionClassFIve.ConnecionClass5();
        String sql = "INSERT INTO customers(name, email, birth, photo) VALUES(?,?,?,?)";
        ps = connection.prepareStatement(sql);
        ps.setString(1, "����");
        ps.setString(2, "zhang@qq.com");
        ps.setObject(3, "1999-09-21");
        // �� io ���������ļ������������ FileInputStream ���Ͷ������
        FileInputStream is = new FileInputStream("C:\\Users\\lenovo\\Pictures\\1.webp");
        ps.setBlob(4, is);
        ps.execute();
        close.closeResource(connection, ps);
    }
    public static void SelectBlob(Connection connection, PreparedStatement ps) throws Exception{
        connection = ConnectionClassFIve.ConnecionClass5();
        String sql = "SELECT id,name,email,birth,photo FROM customers WHERE id = ?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, 16);
        ResultSet rs = ps.executeQuery();
        Blob photo = null;
        if(rs.next())
        {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            Date birth = rs.getDate(4);
            Customer customer = new Customer(id, name, email, birth);
            System.out.println(customer);
            photo = rs.getBlob(5);
            // �������ݶ�ȡ Blob �ļ�
            InputStream is = photo.getBinaryStream();
            // ���ļ����浽����
            FileOutputStream fos = new FileOutputStream("����.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1)
            {
                fos.write(buffer, 0, len);
            }
        }
        close.closeResource(connection, ps, rs);
    }
    public static void ManyDataOperator(Connection connection, PreparedStatement ps) throws Exception  {
        /*
         * ʹ�� PreparedStatement ʵ���������ݲ���
         * ��Ҫչʾʹ�� PreparedStatement ���ʵ�ָ�Ч�������������
         * ��Ŀ�� �� goods ���в��� 20000������
        */
        String sql = "INSERT INTO goods(name) VALUE(?)";
        ps = connection.prepareStatement(sql);
        for(int i = 0; i < 20000; i++)
        {
            ps.setString(1, "name_"+i);
            ps.execute();
        }
        close.closeResource(connection, ps);
    }
    public static void OptimizeOperator(Connection connection, PreparedStatement ps) throws Exception {
        // �� ManyDataOperator �������Ż��� ���ٶ�ȡһ�� i ���һ��ռλ�������ǵ�һ������һ�����
        connection = ConnectionClassFIve.ConnecionClass5();
        String sql = "INSERT INTO goods(name) VALUE(?)";
        ps = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++)
        {
            ps.setString(1, "name_"+i);
            // ������, batch ������Ĭ������£�mysql�ǲ�֧��������ģ�����Ҫ�� �����ļ� url �����һ�� rewriteBatchedStatements=true;
            ps.addBatch();
            // ÿ�� 500 �β���һ�����ݣ�һ�β��� 500����������500�������ύ�����ݿ�
            if(i % 500 == 0)
                ps.executeBatch();
            // ��� Batch()
            ps.clearBatch();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        close.closeResource(connection, ps);
    }
    public static void OptimizeConnection() throws Exception {
        Connection connection = ConnectionClassFIve.ConnecionClass5();
        String sql = "INSERT INTO goods(name) VALUES(?)";
        long start = System.currentTimeMillis();
        PreparedStatement ps = connection.prepareStatement(sql);
        // �������Զ��ύ���ݣ���������ݴ���һ���ύ
        connection.setAutoCommit(false);
        for(int i = 0; i < 20000; i++)
        {
            ps.setString(1, "name_"+i);
            ps.addBatch();
            if(i % 500 == 0)
            {
                // �������� 500 �����ݣ������Զ��ύ����
                ps.executeBatch();
                ps.clearBatch();
            }
        }
        // ������һ���ύ��ȥ
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        close.closeResource(connection, ps);
    }
    public static void OptimizeUniverseDML(Connection connection, String sql, Object... args) throws Exception {
        // ��ͨ�õ���ɾ�Ĳ�����UniverseOperation�������Ż�,���������������
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.���ռλ��
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i + 1, args[i]);
            // ע�⣺ռλ�����Ǵ� 1��ʼ�ģ����� i Ҫ�� 1
        }

        // 4.�ύ����
        ps.execute();
        System.out.println("��ɲ���");
        //  close.closeResource(connection, ps);
        //  ���Ӳ��ں����ڲ����ɣ�����һ������ connection, ͬʱҲ���ں����ڲ��ر����ӣ�
        //  ���ⲿ���������ύ���ر����ӣ��������ⲿ rollback ����
    }
}
