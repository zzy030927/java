package com.connection;


import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//�ر�����
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
//   ���عر���Դ�Ĳ�������һ���رս�����Ĳ���
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