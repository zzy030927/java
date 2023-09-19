package Program.bookManager.dao;

import Program.bookManager.model.User;
import Program.bookManager.utils.ToolUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public int addUser(Connection connection, User user) {
        try {
            // �����û�����ѯ���ݿ�
            String sql = "SELECT * FROM User WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);   // Ԥ����
            ps.setString(1, user.getUserName());
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {         // �������������
                return 2;
            }
            // �������
            String update_sql = "INSERT INTO user(username, password, role, sex, phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(update_sql);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassword());
            pst.setInt(3, user.getRole());
            pst.setString(4, user.getSex());
            pst.setString(5, user.getPhone());
            return pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User login(Connection con, User user) {
        // ����һ�� user ���͵ı�������¼��ѯ�����Ľ��
        User resultUser = null;
        try {
            // ���� sql ���
            String sql = "SELECT * FROM user WHERE username = ? AND password = ? AND role = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultUser = new User();
                resultUser.setUserId(rs.getInt("id"));
                resultUser.setUserName(rs.getString("username"));
                resultUser.setSex(rs.getString("role"));
                resultUser.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultUser;
    }
    public ResultSet list(Connection con,User user)throws Exception{
        StringBuffer sb=new StringBuffer("select * from user where role = 1");
        if(!ToolUtils.isEmpty(user.getUserName())){
            sb.append(" and username like '%"+user.getUserName()+"%'");
        }
        PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }

    public int update(Connection con,User user)throws Exception{
        String sql="update user set username=?,password=?,sex=?,phone=? where id=?";
        PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getSex());
        pstmt.setString(4, user.getPhone());
        pstmt.setInt(5, user.getUserId());
        return pstmt.executeUpdate();
    }
}
