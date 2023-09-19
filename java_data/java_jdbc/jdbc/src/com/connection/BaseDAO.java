package com.connection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

// ��װ�����ݱ��ͨ�õĲ���
// �����ֻ���ṩһЩ����������ȥʵ������
public abstract class BaseDAO<T>   // ��Ϊ����ʵ��������������Ϊ abstract
{
    private Class<T> clazz = null;
    // �Ǿ�̬�����ʵ���� clazz
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();        // ��ȡ��ǰ����Ĵ����͵ĸ��࣬Ҳ���ǻ�ȡ Base<Customer>,��ǰ������ Customer
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;    // ǿתΪ���Դ�����������
        Type[] actualTypeArguments = paramType.getActualTypeArguments();        // ��ȡ����ķ��Ͳ���
        clazz = (Class<T>) actualTypeArguments[0];                              // ��Ϊֻ��һ������ Customer,�����õ�һ����������ǿתΪҪ��������ͣ�Ҳ���� Customer
    }
    public void OptimizeUniverseDML(Connection connection, String sql, Object... args) throws Exception  {
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
        close.closeResource(null, ps);
        //  ���Ӳ��ں����ڲ����ɣ�����һ������ connection, ͬʱҲ���ں����ڲ��ر����ӣ�
        //  ���ⲿ���������ύ���ر����ӣ��������ⲿ rollback ����
    }
    public T UniverseSelectSQL(Connection connection, String sql, Object ...args) throws Exception {
        // ʹ�� PreparedStatement ʵ����Բ�ͬ��Ĳ�ѯ����

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
            close.closeResource(null, ps, rs);
            return t;
        }
        close.closeResource(null, ps, rs);
        return null;
    }
    public List<T> SelectManyResult(Connection connection, String sql, Object ...args) throws Exception {
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
        close.closeResource(null, ps, rs);
        return list;
    }
    public <T>T getValue(Connection connection, String sql) throws Exception {
        // ��� SELECT COUNT(*) FROM TABLE; ���൥�к����Ĳ������з���һ�����ݣ���Ϊ��ȷ����ʲô���ͣ������õ��˷��͡�
        PreparedStatement ps = null;
        ps = connection.prepareStatement(sql);
        ResultSet rs = null;
        rs = ps.executeQuery();
        if(rs.next())
        {
            return  (T) rs.getObject(1);
        }
        return null;
    }
}
