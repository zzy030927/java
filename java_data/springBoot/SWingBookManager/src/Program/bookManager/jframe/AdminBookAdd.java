package Program.bookManager.jframe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import Program.bookManager.dao.BookDao;
import Program.bookManager.dao.BookTypeDao;
import Program.bookManager.model.Book;
import Program.bookManager.model.BookType;
import Program.bookManager.utils.DbUtils;
import Program.bookManager.utils.ToolUtils;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class AdminBookAdd extends JFrame {
    private JFrame jf;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_6;
    private JComboBox comboBox;
    BookDao bookDao=new BookDao();
    DbUtils dbUtil=new DbUtils();
    BookTypeDao bookTypeDao=new BookTypeDao();
    public AdminBookAdd(){
        jf=new JFrame("����Ա����");
        jf.setBounds(400, 100, 600, 378);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u4E66\u7C4D\u6DFB\u52A0", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
        panel.setBounds(23, 21, 540, 275);
        jf.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("������");
        lblNewLabel.setFont(new Font("��Բ", Font.BOLD, 14));
        lblNewLabel.setBounds(58, 31, 45, 27);
        panel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(101, 31, 129, 27);
        panel.add(textField);
        textField.setColumns(10);

        JLabel label = new JLabel("���ߣ�");
        label.setFont(new Font("��Բ", Font.BOLD, 14));
        label.setBounds(294, 31, 45, 27);
        panel.add(label);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(338, 31, 128, 27);
        panel.add(textField_1);

        JLabel label_1 = new JLabel("�����磺");
        label_1.setFont(new Font("��Բ", Font.BOLD, 14));
        label_1.setBounds(43, 79, 60, 27);
        panel.add(label_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(101, 79, 129, 27);
        panel.add(textField_2);

        JLabel label_2 = new JLabel("��棺");
        label_2.setFont(new Font("��Բ", Font.BOLD, 14));
        label_2.setBounds(58, 125, 45, 27);
        panel.add(label_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(101, 125, 129, 27);
        panel.add(textField_3);

        JLabel label_3 = new JLabel("�۸�");
        label_3.setFont(new Font("��Բ", Font.BOLD, 14));
        label_3.setBounds(294, 79, 45, 27);
        panel.add(label_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(337, 79, 129, 27);
        panel.add(textField_4);

        JLabel label_4 = new JLabel("���");
        label_4.setFont(new Font("��Բ", Font.BOLD, 14));
        label_4.setBounds(294, 125, 45, 27);
        panel.add(label_4);

        JLabel label_5 = new JLabel("������");
        label_5.setFont(new Font("��Բ", Font.BOLD, 14));
        label_5.setBounds(58, 170, 45, 27);
        panel.add(label_5);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(101, 173, 365, 27);
        panel.add(textField_6);

        JButton btnNewButton = new JButton("���");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookName = textField.getText();
                String author = textField_1.getText();
                String publish = textField_2.getText();
                String priceStr = textField_4.getText();
                String numberStr = textField_3.getText();
                String remark = textField_6.getText();
                if (ToolUtils.isEmpty(bookName) || ToolUtils.isEmpty(author)
                        || ToolUtils.isEmpty(publish) || ToolUtils.isEmpty(priceStr)
                        || ToolUtils.isEmpty(numberStr) || ToolUtils.isEmpty(remark)) {
                    JOptionPane.showMessageDialog(null, "�������������");
                    return;
                }
                BookType selectedItem = (BookType) comboBox.getSelectedItem();
                Integer typeId = selectedItem.getTypeId();
                int number;
                double price;
                try {
                    number = Integer.parseInt(numberStr);
                    price = new BigDecimal(priceStr).setScale(2, BigDecimal.ROUND_DOWN)
                            .doubleValue();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "��������");
                    return;
                }
                Book book = new Book();
                book.setBookName(bookName);
                book.setAuthor(author);
                book.setBookTypeId(typeId);
                book.setNumber(number);
                book.setPrice(price);
                book.setPublish(publish);
                book.setRemark(remark);
                book.setStatus(1);
                Connection con = null;
                try {
                    con = dbUtil.getConnection();
                    int i = bookDao.add(con, book);
                    if (i == 1) {
                        JOptionPane.showMessageDialog(null, "��ӳɹ�");
                        reset();
                    } else {
                        JOptionPane.showMessageDialog(null, "���ʧ��");
                    }
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "����쳣");
                }
            }
        });
        btnNewButton.setFont(new Font("��Բ", Font.BOLD, 14));
        btnNewButton.setBounds(124, 227, 77, 27);
        panel.add(btnNewButton);

        JButton button = new JButton("����");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        button.setFont(new Font("��Բ", Font.BOLD, 14));
        button.setBounds(329, 229, 77, 27);
        panel.add(button);

        comboBox = new JComboBox();
        comboBox.setBounds(338, 126, 128, 26);
        panel.add(comboBox);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(AdminBookAdd.class.getResource("/tupian/adBG2.png")));
        lblNewLabel_1.setBounds(0, -4, 584, 323);
        jf.getContentPane().add(lblNewLabel_1);
        getBookType();

        JMenuBar menuBar = new JMenuBar();
        jf.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("������");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("������");
        mntmNewMenuItem.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminMenuFrm();
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("����޸�");
        mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminBTypeEdit();
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_2 = new JMenu("�鼮����");
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("�鼮���");
        mnNewMenu_2.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("�鼮�޸�");
        mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminBookEdit();
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_3);

        JMenu menu1 = new JMenu("�û�����");
        menuBar.add(menu1);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("�û���Ϣ");
        mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminUserInfo();
            }
        });
        menu1.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("������Ϣ");
        mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminBorrowInfo();
            }
        });
        menu1.add(mntmNewMenuItem_5);

        JMenu mnNewMenu_1 = new JMenu("�˳�ϵͳ");
        mnNewMenu_1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                JOptionPane.showMessageDialog(null, "��ӭ�ٴ�ʹ��");
                jf.dispose();
            }
        });
        menuBar.add(mnNewMenu_1);




        jf.setVisible(true);
        jf.setResizable(true);
    }
    protected void reset() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
        textField_6.setText("");

    }
    private void getBookType() {
        Connection con = null;
        try {
            con = DbUtils.getConnection();
            ResultSet list = bookTypeDao.list(con, new BookType());
            while (list.next()) {
                BookType bookType = new BookType();
                bookType.setTypeId(list.getInt("id"));
                bookType.setTypeName(list.getString("type_name"));
                comboBox.addItem(bookType);
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
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AdminBookAdd();
    }
}
