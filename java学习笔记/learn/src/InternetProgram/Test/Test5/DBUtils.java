package InternetProgram.Test.Test5;
import org.junit.Test;

import java.sql.*;
public class DBUtils {
    private Connection connection;
    private PreparedStatement ps = null;

    public void dbConnect(){
        try {
            Class.forName(Contact.DRIVER);
            connection = DriverManager.getConnection(Contact.DB_URL, Contact.DB_USERNAME, Contact.PASSWORD);
            System.out.println("连接数据库成功");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String queryById(int id){
        User user = new User();
        try {
            String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setBirthday(resultSet.getDate("birth"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user.toString();
    }
}
