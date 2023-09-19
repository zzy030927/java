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

// 封装了数据表的通用的操作
// 这个类只是提供一些方法，不会去实例化。
public abstract class BaseDAO<T>   // 因为不能实例化，所以声明为 abstract
{
    private Class<T> clazz = null;
    // 非静态代码块实例化 clazz
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();        // 获取当前对象的带泛型的父类，也就是获取 Base<Customer>,当前对象是 Customer
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;    // 强转为可以带参数的类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();        // 获取父类的泛型参数
        clazz = (Class<T>) actualTypeArguments[0];                              // 因为只有一个参数 Customer,所以用第一个索引，再强转为要传入的类型，也就是 Customer
    }
    public void OptimizeUniverseDML(Connection connection, String sql, Object... args) throws Exception  {
        // 对通用的增删改操作（UniverseOperation）进行优化,考虑了事务的属性
        PreparedStatement ps = connection.prepareStatement(sql);

        // 3.填充占位符
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i + 1, args[i]);
            // 注意：占位符都是从 1开始的，所以 i 要加 1
        }

        // 4.提交数据
        ps.execute();
        System.out.println("完成操作");
        close.closeResource(null, ps);
        //  连接不在函数内部生成，传入一个连接 connection, 同时也不在函数内部关闭连接，
        //  在外部所有数据提交完后关闭连接，否则在外部 rollback 数据
    }
    public T UniverseSelectSQL(Connection connection, String sql, Object ...args) throws Exception {
        // 使用 PreparedStatement 实现针对不同表的查询操作

        //预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        //填充占位符
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i + 1, args[i]);
        }

        // 提交数据并返回结果集
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        if(rs.next())
        {
            T t = clazz.getConstructor().newInstance();
            // 给任何一个类提供一个空参的 public 权限的构造器
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
        // 2.预编译
        PreparedStatement ps = connection.prepareStatement(sql);
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i+1, args[i]);
        }

        // 3.提交数据并返回结果
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
        // 针对 SELECT COUNT(*) FROM TABLE; 这类单行函数的操作进行返回一条数据，因为不确定是什么类型，所以用到了泛型。
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
