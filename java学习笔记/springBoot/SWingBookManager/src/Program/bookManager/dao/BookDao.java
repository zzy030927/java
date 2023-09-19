package Program.bookManager.dao;

import Program.bookManager.model.Book;
import Program.bookManager.utils.ToolUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao {

    // 书籍数量查询


    // 图书添加
    public int add(Connection con, Book book) throws Exception {
        String sql = "insert into book (book_name,type_id,author,publish,price,number,status,remark) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setInt(2, book.getBookTypeId());
        pstmt.setString(3, book.getAuthor());
        pstmt.setString(4, book.getPublish());
        pstmt.setDouble(5, book.getPrice());
        pstmt.setInt(6, book.getNumber());
        pstmt.setInt(7, book.getStatus());
        pstmt.setString(8, book.getRemark());
        return pstmt.executeUpdate();
    }

    // 图书信息查询
    public ResultSet list(Connection con, Book book) throws Exception {
        StringBuffer sb = new StringBuffer("select b.*,bt.type_name from book b,book_type bt where b.type_id=bt.id");
        if (!ToolUtils.isEmpty(book.getBookName())) {
            sb.append(" and b.book_name like '%" + book.getBookName() + "%'");
        }
        if (!ToolUtils.isEmpty(book.getAuthor())) {
            sb.append(" and b.author like '%" + book.getAuthor() + "%'");
        }
        if (book.getBookTypeId() != null && book.getBookTypeId() != 0) {
            sb.append(" and b.type_id=" + book.getBookTypeId());
        }
        if (book.getStatus() != null) {
            sb.append(" and b.status=" + book.getStatus());
        }
        if (book.getBookId() != null) {
            sb.append(" and b.id=" + book.getBookId());
        }
        sb.append(" ORDER BY b.status");
        PreparedStatement ps = con.prepareStatement(sb.toString());
        return ps.executeQuery();


    }

    // 图书信息查询(学生)
    public ResultSet listCan(Connection con, Book book) throws Exception {
        StringBuffer sb = new StringBuffer("select b.*,bt.type_name from book b,book_type bt where type_id=bt.id and b.status = 1");
        if (!ToolUtils.isEmpty(book.getBookName())) {
            sb.append(" and b.book_name like '%" + book.getBookName() + "%'");
        }
        if (book.getBookId() != null) {
            sb.append(" and b.id=" + book.getBookId());
        }
        PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }

    //图书信息删除
    public int delete(Connection con, String id) throws Exception {
        String sql = "delete from book where id=?";
        PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
        pstmt.setString(1, id);
        return pstmt.executeUpdate();
    }

    //图书信息修改
    public int update(Connection con, Book book) throws Exception {
        String sql = "update book set book_name=?,type_id=?,author=?,publish=?,price=?,number=?,status=?,remark=? where id=?";
        PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setInt(2, book.getBookTypeId());
        pstmt.setString(3, book.getAuthor());
        pstmt.setString(4, book.getPublish());
        pstmt.setDouble(5, book.getPrice());
        pstmt.setInt(6, book.getNumber());
        pstmt.setInt(7, book.getStatus());
        pstmt.setString(8, book.getRemark());
        pstmt.setInt(9, book.getBookId());
        return pstmt.executeUpdate();
    }

    public int selectNum(Connection con, int bookId) throws SQLException {
        String sql = "SELECT * FROM book WHERE id = ?";
        int number =  0;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, bookId);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            number = resultSet.getInt("number");
        }
        return number;
    }

    public void updateNum(Connection con, int bookId, boolean flag) throws SQLException {
        StringBuffer sql = new StringBuffer("UPDATE book SET number = ");
        if (flag)
            sql.append("number - 1 WHERE id = ?");
        else
            sql.append("number + 1 WHERE id = ?");
        PreparedStatement ps = con.prepareStatement(sql.toString());
        ps.setInt(1, bookId);
        ps.executeUpdate();
    }
}
