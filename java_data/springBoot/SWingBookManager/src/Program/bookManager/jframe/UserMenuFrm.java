package Program.bookManager.jframe;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import Program.bookManager.dao.BookDao;
import Program.bookManager.dao.BorrowDetailDao;
import Program.bookManager.model.Book;
import Program.bookManager.model.BorrowDetail;
import Program.bookManager.utils.DbUtils;
import Program.bookManager.utils.ToolUtils;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class UserMenuFrm extends JFrame {
    private JFrame jf;                          // 主界面的 JFrame
    private JLabel lblNewLabel_1;               // 展示当前登录 `用户名` 所需要的 JLabel
    private JLabel lblNewLabel_2;               // 展示顶部 `欢迎您` 三个字所需要的 JLabel
    private JTable table;                       // 借阅信息的表格组件
    private DefaultTableModel model;            // 借阅信息的表格组件所需要的数据模型对象
    private JTextField textField;               // 输入还书编号所需要的 JTextField
    private JButton btnBackBook;                // 还书按钮
    private JButton button;                     // 退出系统按钮
    private JPanel panel_2;                     // 初始化展示图书信息所需要的面板
    private JComboBox comboBox;                 // 搜索关键字所需要的下拉选择框
    private JTextField textField_1;             // 搜索关键字所需要的文本框
    private JButton button_1;                   // 查询按钮
    private JTable bookTable;                   // 展示图书信息所需要的表格组件
    private DefaultTableModel bookModel;        // 展示图书信息所需要的数据模型组件
    private JTextField textField_2;             // 展示所 借书 `编号` 所需要的文本框组件
    private JTextField textField_3;             // 展示 借书 `书名` 所需要的文本框组件
    private JLabel lblNewLabel_3;               // 展示图片背景所需要的 JLabel
    private BorrowDetailDao bDetailDao = new BorrowDetailDao();
    private BookDao bookDao = new BookDao();

    public UserMenuFrm() {
        // 初始化用户操作的主界面
        jf = new JFrame();
        jf.setTitle("用户页面");
        jf.setBounds(250, 100, 700, 902);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u501F\u9605\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
        panel_1.setBounds(23, 48, 651, 239);

        // 做一个表头栏数据  一维数组
        String[] title = {"编号", "书名", "状态", "借书时间", "还书时间"};
        //具体的各栏行记录 先用空的二位数组占位
        String[][] dates = {};
        //然后实例化 上面 2个控件对象
        model = new DefaultTableModel(dates, title);
        table = new JTable();
        table.setModel(model);

        //逻辑查询历史借阅记录
        putDates(new BorrowDetail());   //获取数据库数据放置 table 中
        // 将表格组件添加到 jScrollPane中，并且将 JScrollPane添加到 pane_1 中，在将 pane_1 添加到 JFrame中
        panel_1.setLayout(null);
        JScrollPane jscrollpane = new JScrollPane();
        jscrollpane.setBounds(20, 22, 607, 188);
        jscrollpane.setViewportView(table);
        panel_1.add(jscrollpane);
        jf.getContentPane().add(panel_1);

        lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setForeground(Color.RED);
        lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
        lblNewLabel_1.setBounds(315, 10, 197, 28);
        jf.getContentPane().add(lblNewLabel_1);
        lblNewLabel_1.setText(LoginFrm.currentUser.getUserName());

        lblNewLabel_2 = new JLabel("欢迎您,");
        lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
        lblNewLabel_2.setBounds(254, 11, 258, 28);
        jf.getContentPane().add(lblNewLabel_2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8FD8\u4E66", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
        panel.setBounds(23, 294, 651, 70);
        jf.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("编号：");
        lblNewLabel.setBounds(90, 25, 51, 27);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 16));

        textField = new JTextField();
        textField.setBounds(145, 28, 116, 24);
        panel.add(textField);
        textField.setColumns(10);

        btnBackBook = new JButton("还书");
        btnBackBook.setFont(new Font("Dialog", Font.BOLD, 15));
        btnBackBook.setBounds(299, 25, 85, 31);
        panel.add(btnBackBook);

        button = new JButton("退出系统");
        button.setFont(new Font("Dialog", Font.BOLD, 15));
        button.setBounds(407, 25, 103, 31);
        panel.add(button);

        panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "借阅信息", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
        panel_2.setBounds(23, 374, 651, 346);
        jf.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(252, 23, 135, 27);
        panel_2.add(textField_1);

        button_1 = new JButton("查询");
        button_1.addActionListener(new ActionListener() {       // 查询逻辑代码
            public void actionPerformed(ActionEvent e) {
                int index = comboBox.getSelectedIndex();        // 获取选中索引
                if (index == 0) {
                    String bookName = textField_1.getText();
                    Book book = new Book();
                    book.setBookName(bookName);
                    putDates(book);
                } else {
                    String authorName = textField_1.getText();
                    Book book = new Book();
                    book.setAuthor(authorName);
                    putDates(book);
                }
            }
        });
        textField_1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if ("".equals(textField_1.getText()))
                    putDates(new Book());
            }
        });

        button_1.setFont(new Font("幼圆", Font.BOLD, 16));
        button_1.setBounds(408, 20, 93, 33);
        panel_2.add(button_1);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("幼圆", Font.BOLD, 15));
        comboBox.setBounds(123, 26, 109, 24);
        comboBox.addItem("书籍名称");
        comboBox.addItem("书籍作者");
        panel_2.add(comboBox);

        String[] BookTitle = {"编号", "书名", "类型", "作者", "描述", "数量"};
        // 具体的各栏行记录 先用空的二位数组占位
        String[][] BookDates = {};
        //然后实例化 上面 2个控件对象
        bookModel = new DefaultTableModel(BookDates, BookTitle);
        bookTable = new JTable(bookModel);
        putDates(new Book());   //获取数据库数据放置 table 中
        panel_2.setLayout(null);
        JScrollPane jscrollpane1 = new JScrollPane();
        jscrollpane1.setBounds(22, 74, 607, 250);
        jscrollpane1.setViewportView(bookTable);
        panel_2.add(jscrollpane1);
        jf.getContentPane().add(panel_1);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "\u501F\u4E66", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
        panel_3.setBounds(23, 730, 645, 87);
        jf.getContentPane().add(panel_3);
        panel_3.setLayout(null);

        JLabel label = new JLabel("编号：");
        label.setFont(new Font("Dialog", Font.BOLD, 15));
        label.setBounds(68, 31, 48, 33);
        panel_3.add(label);

        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        textField_2.setBounds(126, 34, 135, 27);
        panel_3.add(textField_2);

        JLabel label_1 = new JLabel("书名：");
        label_1.setFont(new Font("Dialog", Font.BOLD, 15));
        label_1.setBounds(281, 31, 48, 33);
        panel_3.add(label_1);

        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        textField_3.setBounds(339, 34, 135, 27);
        panel_3.add(textField_3);

        JButton button_2 = new JButton("借书");
        //借书
        button_2.addActionListener(new ActionListener() {           // 借书的相关逻辑
            public void actionPerformed(ActionEvent e) {
                String bookId = textField_2.getText();
                String bookName = textField_3.getText();
                if (ToolUtils.isEmpty(bookId) || ToolUtils.isEmpty(bookName)) {
                    JOptionPane.showMessageDialog(null, "请选择相关书籍");
                    return;
                }
                BorrowDetail borrowDetail = new BorrowDetail();
                borrowDetail.setUserId(LoginFrm.currentUser.getUserId());
                borrowDetail.setBookId(Integer.parseInt(bookId));
                borrowDetail.setStatus(1);      // 1 代表 已借
                borrowDetail.setBorrowTime(ToolUtils.getTime());
                Connection con = null;
                try {
                    con = DbUtils.getConnection();

                    //先查询是否有该书
                    ResultSet list = bDetailDao.list(con, borrowDetail);
                    while (list.next()) {
                        JOptionPane.showMessageDialog(null, "该书已在借,请先还再借");
                        return;
                    }
                    int bookNumber = bookDao.selectNum(con, Integer.parseInt(bookId));
                    if (bookNumber > 0 && bDetailDao.add(con, borrowDetail) == 1) {     // 有书，并且添加成功添加借阅信息
                        JOptionPane.showMessageDialog(null, "借书成功");
                        bookDao.updateNum(con, Integer.parseInt(bookId), true);               // 更新书籍数量
                        int selectedRow = bookTable.getSelectedRow();
                        bookTable.setValueAt(bookNumber - 1, selectedRow, 5);
                        putDates(new BorrowDetail());
                    } else {
                        JOptionPane.showMessageDialog(null, "借书失败");
                    }
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "借书异常");
                } finally {
                    try {
                        DbUtils.closeConnection(con);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });
        button_2.setFont(new Font("Dialog", Font.BOLD, 16));
        button_2.setBounds(495, 31, 80, 33);
        panel_3.add(button_2);

        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(UserMenuFrm.class.getResource("/tupian/uBG.png")));
        lblNewLabel_3.setBounds(0, 0, 684, 864);
        jf.getContentPane().add(lblNewLabel_3);

        bookTable.addMouseListener(new MouseAdapter() {     // 借书的鼠标监听器
            public void mousePressed(MouseEvent evt) {
                tableMousePressed(evt);
            }
        });


        button.addActionListener(new ActionListener() {     // 退出按钮的鼠标监听器
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "欢迎再次使用");
                jf.dispose();
            }
        });
        btnBackBook.setVisible(false);
        btnBackBook.addActionListener(new ActionListener() {        // 给还书按钮添加监听器
            public void actionPerformed(ActionEvent e) {
                String BorrowStr = textField.getText();
                if (ToolUtils.isEmpty(BorrowStr)) {
                    JOptionPane.showMessageDialog(null, "请选择未还的书籍");
                    return;
                }
                BorrowDetail detail = new BorrowDetail();       // 封装还书操作所对应的数据
                detail.setBorrowId(Integer.parseInt(BorrowStr));
                detail.setStatus(2);
                detail.setReturnTime(ToolUtils.getTime());
                Connection con = null;
                try {
                    con = DbUtils.getConnection();
                    int i = bDetailDao.returnBook(con, detail);
                    if (i == 1) {
                        int bookId = bDetailDao.selectId(con, detail);
                        bookDao.updateNum(con, bookId, false);               // 更新书籍数量
                        int bookNumber = bookDao.selectNum(con, bookId);
                        bookTable.setValueAt(bookNumber, bookId - 1, 5);
                        JOptionPane.showMessageDialog(null, "还书成功");
                    } else {
                        JOptionPane.showMessageDialog(null, "还书失败");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "还书异常");
                } finally {
                    try {
                        DbUtils.closeConnection(con);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                // 不管成功还是失败，重新查询借阅信息
                putDates(new BorrowDetail());
            }
        });

        jf.setVisible(true);
        jf.setResizable(true);
    }

    // 获取当前用户所选择的数据行，然后将该行的数据在借书面板的相关组件中进行展示
    protected void tableMousePressed(MouseEvent evt) {
        int row = bookTable.getSelectedRow();
        Object bookId = bookTable.getValueAt(row, 0);
        Object bookName = bookTable.getValueAt(row, 1);
        textField_2.setText(bookId.toString());
        textField_3.setText(bookName.toString());
    }

    //从数据库获取书籍信息
    private void putDates(Book book) {
        // 获取数据模型对象
        DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
        model.setRowCount(0);   // 设置行数
        Connection con = null;
        try {
            con = DbUtils.getConnection();
            book.setStatus(1);      // 查询上架状态的数据，即 status = 1;
            // 在 bookDao 中进行查询 上架状态为 1 的书
            ResultSet list = bookDao.list(con, book);
            while (list.next()) {
                Vector rowData = new Vector();
                rowData.add(list.getInt("id"));
                rowData.add(list.getString("book_name"));
                rowData.add(list.getString("type_name"));
                rowData.add(list.getString("author"));
                rowData.add(list.getString("remark"));      // 图书详情信息
                rowData.add(list.getInt("number"));
                model.addRow(rowData);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                DbUtils.closeConnection(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    private void putDates(BorrowDetail borrowDetail) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();     // 获取数据模型
        model.setRowCount(0);
        Integer userId = LoginFrm.currentUser.getUserId();
        Connection con = null;
        try {
            con = DbUtils.getConnection();
            borrowDetail.setUserId(userId);
            ResultSet list = bDetailDao.list(con, borrowDetail);
            while (list.next()) {
                Vector rowData = new Vector();      // 每一行需要的的数据
                rowData.add(list.getInt("id"));
                rowData.add(list.getString("book_name"));
                int status = list.getInt("status");
                if (status == 1) {
                    rowData.add("在借");
                }
                if (status == 2) {
                    rowData.add("已还");
                }
                rowData.add(ToolUtils.getDateByTime(list.getLong("borrow_time")));
                if (status == 2) {
                    rowData.add(ToolUtils.getDateByTime(list.getLong("return_time")));
                }
                model.addRow(rowData);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DbUtils.closeConnection(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            table.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me){
                    putBack(me);
                }
            });
        }
    }

    protected void putBack(MouseEvent me) {
        int row = table.getSelectedRow();           // 获取用户所选取的行记录
        Integer borrowId = (Integer) table.getValueAt(row, 0);
        String status = (String) table.getValueAt(row, 2);
        textField.setText(borrowId.toString());
        if (status.equals("在借")) {
            this.btnBackBook.setVisible(true);
        } else {
            this.btnBackBook.setVisible(false);
        }
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new UserMenuFrm();
    }
}