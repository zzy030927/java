package Program.bookManager.model;

public class BorrowDetail {
    private Integer borrowId;       // 唯一的标识
    private Integer userId;         // 用户 Id
    private Integer bookId;         // 图书的 Id
    private Integer status;         // 借阅状态，1 表示借阅， 2 表示已换
    private Long borrowTime;        // 借阅时间
    private Long returnTime;        // 归还时间

    @Override
    public String toString() {
        return "BorrowDetail{" +
                "borrowId=" + borrowId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", status=" + status +
                ", borrowTime=" + borrowTime +
                ", returnTime=" + returnTime +
                '}';
    }
}
