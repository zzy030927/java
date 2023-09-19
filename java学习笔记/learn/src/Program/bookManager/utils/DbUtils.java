package Program.bookManager.utils;

import java.sql.*;

public class DbUtils {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bookmanager?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&rewriteBitchedStatements=true";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "zzy0927";
    // 获取连接
    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    // 关闭连接
    public static void closeConnection(Connection connection) {
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
