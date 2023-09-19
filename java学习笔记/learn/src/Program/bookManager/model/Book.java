package Program.bookManager.model;

public class Book {
    private Integer bookId;         // 图书 Id
    private String bookName;        // 图书名称
    private String author;          // 作者
    private Integer status;         // 图书上下架状态，1代表上架，0代表下架
    private Integer bookTypeId;      // 图书类型所对应的 Id
    private String publish;          // 图书的出版社
    private Integer number;          // 图书库存
    private double price;            // 图书的价格
    private String remark;           // 图书的描述信息

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
