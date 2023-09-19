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
 * 使用 PreparedStatement 来替换 Statement,实现对数据表的增删改查操作
 */

public class preparedStatement
{
    public static void InsertSQL(Connection connection, PreparedStatement ps) throws Exception {
        //value(?,?,?) ?代表一个占位符
        String sql = "INSERT INTO customers(name,email,birth) values(?,?,?)";

        //预编译SQL语句，返回一个 PreparedStatement 的实例
        ps = connection.prepareStatement(sql);

        //填充占位符
        ps.setString(1,"坤");
        ps.setString(2,"ji@gmail.com");
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-DD");
//      对日期进行格式化 y 为 year四位数字, M 为 month两位数字, D为 day 两位数字
        java.util.Date date = sdf.parse("1998-08-02");
//      SimpleDateFormat.parse()用于将输入的特定字符串转换成 Date类的对象
        ps.setDate(3, new Date(date.getTime()));

        //执行 SQL操作
        ps.execute();
        System.out.println("插入成功");

//      返回一个 PreparedStatement 实例，用来关闭连接
        close.closeResource(connection, ps);
    }
    public static void UpdateSQL(Connection connection, PreparedStatement ps) throws Exception {
        // Alter 操作，修改表

        // connection 已经获取数据库连接

        // 预编译SQL语句
        String sql = "UPDATE customers SET name = ? WHERE id = ?";
        ps = connection.prepareStatement(sql);

        // 填充占位符
        ps.setString(1, "莫扎特");
        ps.setInt(2, 18);

        // 提交数据
        ps.execute();
        System.out.println("数据修改成功");

        // 关闭连接
        close.closeResource(connection, ps);
    }
    public static void DeleteSQL(Connection connection, PreparedStatement ps) throws Exception {
        // Delete 删除表操作

        // 1. 获取连接
        // 2. 预编译SQL语句
        String sql = "DELETE FROM customers WHERE id = ?";
        ps = connection.prepareStatement(sql);

        // 3.填充占位符
        ps.setInt(1, 33);

        //4.提交数据
        ps.execute();
        System.out.println("删除成功");

        close.closeResource(connection, ps);
    }
    public static void UniverseOperation(Connection connection, PreparedStatement ps, String sql, Object ...args) throws Exception{
        // 通用的增删改操作
        // Object ...args 为可变形参，具体有几个参数就看传了几个参数，类型为 所有类的父类 Object

        // 1.连接数据库

        // 2.预编译
        ps = connection.prepareStatement(sql);

        // 3.填充占位符
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i + 1, args[i]);
            // 注意：占位符都是从 1开始的，所以 i 要加 1
        }

        // 4.提交数据
        ps.execute();
        System.out.println("完成操作");
        close.closeResource(connection, ps);
    }
    public static void SelectSQL(Connection connection, PreparedStatement ps, ResultSet resultSet) throws Exception {
        // 1.数据库连接
        // 2.预编译
        String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
        ps = connection.prepareStatement(sql);

        // 3.填充字符
        ps.setInt(1, 1);

        // 4.提交数据,返回一个结果集
        // PreparedStatement 接口中有一个方法 executeQuery()：execute:执行，Query:查询，它返回一个结果集
        resultSet = ps.executeQuery();
        // next()判断是否有下一条数据，如果有数据返回 true,指针指向下一个对象
        if(resultSet.next())
        {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Date birth = resultSet.getDate(4);

            Customer customer = new Customer(id, name, email, birth);
            // 将所有数据封装到一个类中，这个类是自己定义的
            System.out.println(customer.toString());
        }
        System.out.println("查找成功");

        close.closeResource(connection, ps, resultSet);
    }
    public static Customer UniverseSpecificSelectSQL(Connection connection, PreparedStatement ps, ResultSet resultSet, String sql, Object ...args) throws Exception {
        //获取数据库连接
        //预编译
        ps = connection.prepareStatement(sql);
        //填充占位符
        for(int i = 0; i < args.length; i++)
        {
            ps.setObject(i+1, args[i]);
        }

        resultSet = ps.executeQuery();
        //获取结果集的元数据：ResultSetMetaData
        ResultSetMetaData rsmd = resultSet.getMetaData();
        //获取元数据的列数，也就是获取传入的 sql 中要查询几列
        int columnCount = rsmd.getColumnCount();
        if(resultSet.next())
        {
            Customer customer = new Customer();
            // 处理结果集中的每一列
            for(int i = 0; i < columnCount; i++)
            {
                // 获取结果集中的一个字段的值
                Object columnValue = resultSet.getObject(i + 1);
                // 用元数据 rsmd 获取这个字段的名字
                String columnName = rsmd.getColumnName(i + 1);

                // 通过反射 找到 customer 类中与 columnName 相同的名字 变量，把 columnValue 的值 赋值给 这个变量
                Field field = Customer.class.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(customer, columnValue);

            }
            System.out.println(customer.toString());
        }
        return null;
    }
    public static <T>T UniverseSelectSQL(Class<T> clazz, String sql, Object ...args) throws Exception {
        // 使用 PreparedStatement 实现针对不同表的查询操作

        // 1.获取连接
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = ConnectionClassFIve.ConnecionClass5();

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
            close.closeResource(connection, ps, rs);
            return t;
        }
        close.closeResource(connection, ps, rs);
        return null;
    }
    public static <T> List<T> SelectManyResult(Class<T> clazz, String sql, Object ...args) throws Exception     {
        // 查询多条记录并返回
        // 1.获取连接
        Connection connection = ConnectionClassFIve.ConnecionClass5();

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
        close.closeResource(connection, ps, rs);
        return list;
    }
    public static void InsertBlob(Connection connection, PreparedStatement ps) throws Exception {
        // 向数据表中插入 blob 类型的字段
        connection = ConnectionClassFIve.ConnecionClass5();
        String sql = "INSERT INTO customers(name, email, birth, photo) VALUES(?,?,?,?)";
        ps = connection.prepareStatement(sql);
        ps.setString(1, "张三");
        ps.setString(2, "zhang@qq.com");
        ps.setObject(3, "1999-09-21");
        // 用 io 输入流把文件输入进来，用 FileInputStream 类型对象接受
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
            // 用流数据读取 Blob 文件
            InputStream is = photo.getBinaryStream();
            // 将文件保存到本地
            FileOutputStream fos = new FileOutputStream("朱茵.jpg");
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
         * 使用 PreparedStatement 实现批量数据操作
         * 主要展示使用 PreparedStatement 如何实现高效的批量插入操作
         * 题目： 向 goods 表中插入 20000条数据
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
        // 对 ManyDataOperator 函数的优化： 不再读取一个 i 填充一个占位符，而是等一批数据一起填充
        connection = ConnectionClassFIve.ConnecionClass5();
        String sql = "INSERT INTO goods(name) VALUE(?)";
        ps = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++)
        {
            ps.setString(1, "name_"+i);
            // 攒数据, batch 批处理，默认情况下，mysql是不支持批处理的，所以要在 配置文件 url 后面加一个 rewriteBatchedStatements=true;
            ps.addBatch();
            // 每隔 500 次插入一遍数据，一次插入 500条，并把这500条数据提交到数据库
            if(i % 500 == 0)
                ps.executeBatch();
            // 清空 Batch()
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
        // 不允许自动提交数据，等最后数据传完一起提交
        connection.setAutoCommit(false);
        for(int i = 0; i < 20000; i++)
        {
            ps.setString(1, "name_"+i);
            ps.addBatch();
            if(i % 500 == 0)
            {
                // 这里光插入 500 条数据，不再自动提交数据
                ps.executeBatch();
                ps.clearBatch();
            }
        }
        // 把数据一起提交上去
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        close.closeResource(connection, ps);
    }
    public static void OptimizeUniverseDML(Connection connection, String sql, Object... args) throws Exception {
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
        //  close.closeResource(connection, ps);
        //  连接不在函数内部生成，传入一个连接 connection, 同时也不在函数内部关闭连接，
        //  在外部所有数据提交完后关闭连接，否则在外部 rollback 数据
    }
}
