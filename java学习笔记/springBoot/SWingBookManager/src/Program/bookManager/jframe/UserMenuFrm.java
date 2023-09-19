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
    private JFrame jf;                          // ������� JFrame
    private JLabel lblNewLabel_1;               // չʾ��ǰ��¼ `�û���` ����Ҫ�� JLabel
    private JLabel lblNewLabel_2;               // չʾ���� `��ӭ��` ����������Ҫ�� JLabel
    private JTable table;                       // ������Ϣ�ı�����
    private DefaultTableModel model;            // ������Ϣ�ı���������Ҫ������ģ�Ͷ���
    private JTextField textField;               // ���뻹��������Ҫ�� JTextField
    private JButton btnBackBook;                // ���鰴ť
    private JButton button;                     // �˳�ϵͳ��ť
    private JPanel panel_2;                     // ��ʼ��չʾͼ����Ϣ����Ҫ�����
    private JComboBox comboBox;                 // �����ؼ�������Ҫ������ѡ���
    private JTextField textField_1;             // �����ؼ�������Ҫ���ı���
    private JButton button_1;                   // ��ѯ��ť
    private JTable bookTable;                   // չʾͼ����Ϣ����Ҫ�ı�����
    private DefaultTableModel bookModel;        // չʾͼ����Ϣ����Ҫ������ģ�����
    private JTextField textField_2;             // չʾ�� ���� `���` ����Ҫ���ı������
    private JTextField textField_3;             // չʾ ���� `����` ����Ҫ���ı������
    private JLabel lblNewLabel_3;               // չʾͼƬ��������Ҫ�� JLabel
    private BorrowDetailDao bDetailDao = new BorrowDetailDao();
    private BookDao bookDao = new BookDao();

    public UserMenuFrm() {
        // ��ʼ���û�������������
        jf = new JFrame();
        jf.setTitle("�û�ҳ��");
        jf.setBounds(250, 100, 700, 902);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u501F\u9605\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
        panel_1.setBounds(23, 48, 651, 239);

        // ��һ����ͷ������  һά����
        String[] title = {"���", "����", "״̬", "����ʱ��", "����ʱ��"};
        //����ĸ����м�¼ ���ÿյĶ�λ����ռλ
        String[][] dates = {};
        //Ȼ��ʵ���� ���� 2���ؼ�����
        model = new DefaultTableModel(dates, title);
        table = new JTable();
        table.setModel(model);

        //�߼���ѯ��ʷ���ļ�¼
        putDates(new BorrowDetail());   //��ȡ���ݿ����ݷ��� table ��
        // ����������ӵ� jScrollPane�У����ҽ� JScrollPane��ӵ� pane_1 �У��ڽ� pane_1 ��ӵ� JFrame��
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

        lblNewLabel_2 = new JLabel("��ӭ��,");
        lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
        lblNewLabel_2.setBounds(254, 11, 258, 28);
        jf.getContentPane().add(lblNewLabel_2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8FD8\u4E66", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
        panel.setBounds(23, 294, 651, 70);
        jf.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("��ţ�");
        lblNewLabel.setBounds(90, 25, 51, 27);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("��Բ", Font.BOLD, 16));

        textField = new JTextField();
        textField.setBounds(145, 28, 116, 24);
        panel.add(textField);
        textField.setColumns(10);

        btnBackBook = new JButton("����");
        btnBackBook.setFont(new Font("Dialog", Font.BOLD, 15));
        btnBackBook.setBounds(299, 25, 85, 31);
        panel.add(btnBackBook);

        button = new JButton("�˳�ϵͳ");
        button.setFont(new Font("Dialog", Font.BOLD, 15));
        button.setBounds(407, 25, 103, 31);
        panel.add(button);

        panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "������Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
        panel_2.setBounds(23, 374, 651, 346);
        jf.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(252, 23, 135, 27);
        panel_2.add(textField_1);

        button_1 = new JButton("��ѯ");
        button_1.addActionListener(new ActionListener() {       // ��ѯ�߼�����
            public void actionPerformed(ActionEvent e) {
                int index = comboBox.getSelectedIndex();        // ��ȡѡ������
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

        button_1.setFont(new Font("��Բ", Font.BOLD, 16));
        button_1.setBounds(408, 20, 93, 33);
        panel_2.add(button_1);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("��Բ", Font.BOLD, 15));
        comboBox.setBounds(123, 26, 109, 24);
        comboBox.addItem("�鼮����");
        comboBox.addItem("�鼮����");
        panel_2.add(comboBox);

        String[] BookTitle = {"���", "����", "����", "����", "����", "����"};
        // ����ĸ����м�¼ ���ÿյĶ�λ����ռλ
        String[][] BookDates = {};
        //Ȼ��ʵ���� ���� 2���ؼ�����
        bookModel = new DefaultTableModel(BookDates, BookTitle);
        bookTable = new JTable(bookModel);
        putDates(new Book());   //��ȡ���ݿ����ݷ��� table ��
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

        JLabel label = new JLabel("��ţ�");
        label.setFont(new Font("Dialog", Font.BOLD, 15));
        label.setBounds(68, 31, 48, 33);
        panel_3.add(label);

        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        textField_2.setBounds(126, 34, 135, 27);
        panel_3.add(textField_2);

        JLabel label_1 = new JLabel("������");
        label_1.setFont(new Font("Dialog", Font.BOLD, 15));
        label_1.setBounds(281, 31, 48, 33);
        panel_3.add(label_1);

        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        textField_3.setBounds(339, 34, 135, 27);
        panel_3.add(textField_3);

        JButton button_2 = new JButton("����");
        //����
        button_2.addActionListener(new ActionListener() {           // ���������߼�
            public void actionPerformed(ActionEvent e) {
                String bookId = textField_2.getText();
                String bookName = textField_3.getText();
                if (ToolUtils.isEmpty(bookId) || ToolUtils.isEmpty(bookName)) {
                    JOptionPane.showMessageDialog(null, "��ѡ������鼮");
                    return;
                }
                BorrowDetail borrowDetail = new BorrowDetail();
                borrowDetail.setUserId(LoginFrm.currentUser.getUserId());
                borrowDetail.setBookId(Integer.parseInt(bookId));
                borrowDetail.setStatus(1);      // 1 ���� �ѽ�
                borrowDetail.setBorrowTime(ToolUtils.getTime());
                Connection con = null;
                try {
                    con = DbUtils.getConnection();

                    //�Ȳ�ѯ�Ƿ��и���
                    ResultSet list = bDetailDao.list(con, borrowDetail);
                    while (list.next()) {
                        JOptionPane.showMessageDialog(null, "�������ڽ�,���Ȼ��ٽ�");
                        return;
                    }
                    int bookNumber = bookDao.selectNum(con, Integer.parseInt(bookId));
                    if (bookNumber > 0 && bDetailDao.add(con, borrowDetail) == 1) {     // ���飬������ӳɹ���ӽ�����Ϣ
                        JOptionPane.showMessageDialog(null, "����ɹ�");
                        bookDao.updateNum(con, Integer.parseInt(bookId), true);               // �����鼮����
                        int selectedRow = bookTable.getSelectedRow();
                        bookTable.setValueAt(bookNumber - 1, selectedRow, 5);
                        putDates(new BorrowDetail());
                    } else {
                        JOptionPane.showMessageDialog(null, "����ʧ��");
                    }
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "�����쳣");
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

        bookTable.addMouseListener(new MouseAdapter() {     // �������������
            public void mousePressed(MouseEvent evt) {
                tableMousePressed(evt);
            }
        });


        button.addActionListener(new ActionListener() {     // �˳���ť����������
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "��ӭ�ٴ�ʹ��");
                jf.dispose();
            }
        });
        btnBackBook.setVisible(false);
        btnBackBook.addActionListener(new ActionListener() {        // �����鰴ť��Ӽ�����
            public void actionPerformed(ActionEvent e) {
                String BorrowStr = textField.getText();
                if (ToolUtils.isEmpty(BorrowStr)) {
                    JOptionPane.showMessageDialog(null, "��ѡ��δ�����鼮");
                    return;
                }
                BorrowDetail detail = new BorrowDetail();       // ��װ�����������Ӧ������
                detail.setBorrowId(Integer.parseInt(BorrowStr));
                detail.setStatus(2);
                detail.setReturnTime(ToolUtils.getTime());
                Connection con = null;
                try {
                    con = DbUtils.getConnection();
                    int i = bDetailDao.returnBook(con, detail);
                    if (i == 1) {
                        int bookId = bDetailDao.selectId(con, detail);
                        bookDao.updateNum(con, bookId, false);               // �����鼮����
                        int bookNumber = bookDao.selectNum(con, bookId);
                        bookTable.setValueAt(bookNumber, bookId - 1, 5);
                        JOptionPane.showMessageDialog(null, "����ɹ�");
                    } else {
                        JOptionPane.showMessageDialog(null, "����ʧ��");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "�����쳣");
                } finally {
                    try {
                        DbUtils.closeConnection(con);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                // ���ܳɹ�����ʧ�ܣ����²�ѯ������Ϣ
                putDates(new BorrowDetail());
            }
        });

        jf.setVisible(true);
        jf.setResizable(true);
    }

    // ��ȡ��ǰ�û���ѡ��������У�Ȼ�󽫸��е������ڽ��������������н���չʾ
    protected void tableMousePressed(MouseEvent evt) {
        int row = bookTable.getSelectedRow();
        Object bookId = bookTable.getValueAt(row, 0);
        Object bookName = bookTable.getValueAt(row, 1);
        textField_2.setText(bookId.toString());
        textField_3.setText(bookName.toString());
    }

    //�����ݿ��ȡ�鼮��Ϣ
    private void putDates(Book book) {
        // ��ȡ����ģ�Ͷ���
        DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
        model.setRowCount(0);   // ��������
        Connection con = null;
        try {
            con = DbUtils.getConnection();
            book.setStatus(1);      // ��ѯ�ϼ�״̬�����ݣ��� status = 1;
            // �� bookDao �н��в�ѯ �ϼ�״̬Ϊ 1 ����
            ResultSet list = bookDao.list(con, book);
            while (list.next()) {
                Vector rowData = new Vector();
                rowData.add(list.getInt("id"));
                rowData.add(list.getString("book_name"));
                rowData.add(list.getString("type_name"));
                rowData.add(list.getString("author"));
                rowData.add(list.getString("remark"));      // ͼ��������Ϣ
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
        DefaultTableModel model = (DefaultTableModel) table.getModel();     // ��ȡ����ģ��
        model.setRowCount(0);
        Integer userId = LoginFrm.currentUser.getUserId();
        Connection con = null;
        try {
            con = DbUtils.getConnection();
            borrowDetail.setUserId(userId);
            ResultSet list = bDetailDao.list(con, borrowDetail);
            while (list.next()) {
                Vector rowData = new Vector();      // ÿһ����Ҫ�ĵ�����
                rowData.add(list.getInt("id"));
                rowData.add(list.getString("book_name"));
                int status = list.getInt("status");
                if (status == 1) {
                    rowData.add("�ڽ�");
                }
                if (status == 2) {
                    rowData.add("�ѻ�");
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
        int row = table.getSelectedRow();           // ��ȡ�û���ѡȡ���м�¼
        Integer borrowId = (Integer) table.getValueAt(row, 0);
        String status = (String) table.getValueAt(row, 2);
        textField.setText(borrowId.toString());
        if (status.equals("�ڽ�")) {
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