package com.connection;


import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//关闭连接
public class close{
    public static void closeResource(Connection connection, PreparedStatement ps) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(connection != null && ps != null)
            System.out.println(connection);
    }
//   重载关闭资源的操作，多一个关闭结果集的操作
    public static void closeResource(Connection connection, PreparedStatement ps, ResultSet rs)
    {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(connection != null && ps != null)
            System.out.println(connection);
        try
        {
            if(rs != null)
                rs.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}