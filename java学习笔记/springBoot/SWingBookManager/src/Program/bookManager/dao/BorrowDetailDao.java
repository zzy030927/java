package Program.bookManager.dao;

import Program.bookManager.model.BorrowDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowDetailDao {
    public ResultSet list(Connection con, BorrowDetail borrowDetail) throws Exception{
        // 创建一个 StringBuffer对象，用来拼接 SQL语句
        StringBuffer sb = new StringBuffer("SELECT bd.*,u.username,b.book_name from borrowdetail bd,user u,book b where u.id=bd.user_id and b.id=bd.book_id");
        // 根据查询条件进行 sql语句拼接
        if(borrowDetail.getUserId() != null){
            sb.append(" and u.id = ?");
        }
        if(borrowDetail.getStatus() != null){
            sb.append(" and bd.status = ?");
        }
        if(borrowDetail.getBookId() != null){
            sb.append(" and bd.book_id = ?");
        }
        sb.append("  order by bd.id");
        PreparedStatement ps = con.prepareStatement(sb.toString());
        if(borrowDetail.getUserId() != null){
            ps.setInt(1, borrowDetail.getUserId());
        }
        if(borrowDetail.getStatus() != null && borrowDetail.getBookId() != null){
            ps.setInt(2, borrowDetail.getStatus());
            ps.setInt(3, borrowDetail.getBookId());
        }
        return ps.executeQuery();
    }

    public int add(Connection con, BorrowDetail borrowDetail) throws Exception {
        String sql = "insert into borrowdetail (user_id,book_id,status,borrow_time) values (?,?,?,?)";
        PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
        pstmt.setInt(1, borrowDetail.getUserId());
        pstmt.setInt(2, borrowDetail.getBookId());
        pstmt.setInt(3, borrowDetail.getStatus());
        pstmt.setLong(4, borrowDetail.getBorrowTime());
        return pstmt.executeUpdate();
    }

    public int returnBook(Connection con, BorrowDetail detail) throws SQLException {
        String sql = "UPDATE borrowdetail SET status = ?, return_time = ? WHERE id = ?";
        int id = -1;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, detail.getStatus());
        ps.setLong(2, detail.getReturnTime());
        ps.setInt(3, detail.getBorrowId());
        return ps.executeUpdate();
    }

    public int selectId(Connection con, BorrowDetail detail) throws SQLException {
        int id = -1;
        String sql1 = "SELECT * FROM borrowdetail WHERE id = ? AND status = ?";
        PreparedStatement ps1 = con.prepareStatement(sql1);
        ps1.setInt(1, detail.getBorrowId());
        ps1.setInt(2, detail.getStatus());
        ResultSet resultSet = ps1.executeQuery();
        if (resultSet.next()){
            id = resultSet.getInt("book_id");
        }
        return id;
    }
}
