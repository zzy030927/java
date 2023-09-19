package Program.bookManager.dao;

import Program.bookManager.model.BookType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookTypeDao {
    public int add(Connection con, BookType bookType) throws SQLException {
        // �����������ȥ��ѯ�������
        String sql1 = "SELECT * FROM book_type WHERE type_name = ?";
        PreparedStatement ps1 = con.prepareStatement(sql1);
        ps1.setString(1, bookType.getTypeName());
        ResultSet resultSet = ps1.executeQuery();
        while (resultSet.next()) {
            return 2;       // ��ǰ����Ѿ�����
        }
        // ���������ݲ������
        String sql2 = "INSERT INTO book_type(type_name, remark) VALUES(?, ?)";
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ps2.setString(1, bookType.getTypeName());
        ps2.setString(2, bookType.getRemark());
        return ps2.executeUpdate();
    }

    public int update(Connection con, BookType bookType) {
        return 0;
    }

    public int delete(Connection con, String typeId) {
        return 0;
    }

    public ResultSet list(Connection con, BookType bookType) {
        return null;
    }
}
