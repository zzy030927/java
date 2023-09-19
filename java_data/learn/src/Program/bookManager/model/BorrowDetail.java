package Program.bookManager.model;

public class BorrowDetail {
    private Integer borrowId;       // Ψһ�ı�ʶ
    private Integer userId;         // �û� Id
    private Integer bookId;         // ͼ��� Id
    private Integer status;         // ����״̬��1 ��ʾ���ģ� 2 ��ʾ�ѻ�
    private Long borrowTime;        // ����ʱ��
    private Long returnTime;        // �黹ʱ��

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
