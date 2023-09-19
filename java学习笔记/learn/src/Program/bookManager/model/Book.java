package Program.bookManager.model;

public class Book {
    private Integer bookId;         // ͼ�� Id
    private String bookName;        // ͼ������
    private String author;          // ����
    private Integer status;         // ͼ�����¼�״̬��1�����ϼܣ�0�����¼�
    private Integer bookTypeId;      // ͼ����������Ӧ�� Id
    private String publish;          // ͼ��ĳ�����
    private Integer number;          // ͼ����
    private double price;            // ͼ��ļ۸�
    private String remark;           // ͼ���������Ϣ

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Integer bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                ", bookTypeId=" + bookTypeId +
                ", publish='" + publish + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", remark='" + remark + '\'' +
                '}';
    }
}
