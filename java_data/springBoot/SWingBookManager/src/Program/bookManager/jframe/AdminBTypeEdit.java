package Program.bookManager.jframe;

import Program.bookManager.dao.BookTypeDao;
import Program.bookManager.model.BookType;
import Program.bookManager.utils.DbUtils;
import Program.bookManager.utils.ToolUtils;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class AdminBTypeEdit extends JFrame {
    private JFrame jf;                                  // չʾ�༭������Ĵ������
    private JTable table;                               // չʾ�����Ϣ�ı�����
    private DefaultTableModel model;                    // ��װ�����Ϣ�ı������ģ�����
    private JTextField textField;                       // ������������Ҫ���ı������
    private JTextField textField_1;
    private JTextField textField_2;
    BookTypeDao bookTypeDao=new BookTypeDao();
    public AdminBTypeEdit(){
        jf=new JFrame("����Ա����");
        jf.setBounds(400, 100, 611, 472);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        jf.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("������");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("������");
        mntmNewMenuItem.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {          // ��д������ҵ���߼�����
                jf.dispose();
                new AdminMenuFrm();
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("����޸�");
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_2 = new JMenu("�鼮����");
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("�鼮���");
        mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminBookAdd();
            }
        });
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

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u7C7B\u522B\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
        panel_1.setBounds(20, 10, 554, 208);

        // ��һ����ͷ������  һλ����
        String[] title={"���","�������","�������"};
        // ����ĸ����м�¼ ���ÿյĶ�λ����ռλ
        String[][] dates={};
        // Ȼ��ʵ���� ���� 2���ؼ�����
        model = new DefaultTableModel(dates,title);
        table = new JTable(model);
        putDates();     //��ȡ���ݿ����ݷ��� table ��
        panel_1.setLayout(null);
        // ����������ӵ� JScrollPane �У��ٽ���������ӵ� panel_1 �У��ٽ� panel_1 ��ӵ� JFrame ��
        JScrollPane jscrollpane = new JScrollPane();
        jscrollpane.setBounds(20, 22, 517, 163);
        jscrollpane.setViewportView(table);
        panel_1.add(jscrollpane);
        jf.getContentPane().add(panel_1);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u7C7B\u522B\u7F16\u8F91", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
        panel.setBounds(20, 228, 554, 168);
        jf.getContentPane().add(panel);
        panel.setLayout(null);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                typeTableMousePressed(evt);
            }
        });

        // ��ʼ��
        JLabel lblNewLabel = new JLabel("��ţ�");
        lblNewLabel.setFont(new Font("��Բ", Font.BOLD, 14));
        lblNewLabel.setBounds(73, 26, 45, 28);
        panel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(116, 30, 92, 24);
        panel.add(textField);
        textField.setColumns(10);

        JLabel label = new JLabel("������ƣ�");
        label.setFont(new Font("��Բ", Font.BOLD, 14));
        label.setBounds(238, 26, 75, 28);
        panel.add(label);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(314, 30, 122, 24);
        panel.add(textField_1);

        JLabel label_1 = new JLabel("������");
        label_1.setFont(new Font("��Բ", Font.BOLD, 14));
        label_1.setBounds(73, 65, 45, 28);
        panel.add(label_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(116, 69, 320, 24);
        panel.add(textField_2);

        JButton btnNewButton = new JButton("�޸�");
        //����޸�
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String typeId = textField.getText();
                String typeName = textField_1.getText();
                String typeRemark = textField_2.getText();
                if (ToolUtils.isEmpty(typeName) || ToolUtils.isEmpty(typeRemark)) {
                    JOptionPane.showMessageDialog(null, "�����������Ϣ");
                    return;
                }
                BookType bookType = new BookType();
                bookType.setTypeId(Integer.parseInt(typeId));
                bookType.setTypeName(typeName);
                bookType.setRemark(typeRemark);
                Connection con = null;
                try {
                    con = DbUtils.getConnection();
                    int i = bookTypeDao.update(con, bookType);
                    if (i == 1) {
                        JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
                        putDates();
                    } else {
                        JOptionPane.showMessageDialog(null, "�޸�ʧ��");
                    }
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "�޸��쳣");
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
        btnNewButton.setFont(new Font("��Բ", Font.BOLD, 14));
        btnNewButton.setBounds(128, 117, 93, 28);
        panel.add(btnNewButton);

        JButton button = new JButton("ɾ��");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String typeId = textField.getText();
                if (ToolUtils.isEmpty(typeId)) {
                    JOptionPane.showMessageDialog(null, "��ѡ�������Ϣ");
                    return;
                }
                Connection con = null;
                try {
                    con = DbUtils.getConnection();
                    int i = bookTypeDao.delete(con, typeId);
                    if (i == 1) {
                        JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
                        putDates();
                    } else if (i == 2) {
                        JOptionPane.showMessageDialog(null, "ɾ��ʧ��-������ٱ���һ��");
                    } else if (i == 3) {
                        JOptionPane.showMessageDialog(null, "ɾ��ʧ��-����������鼮");
                    } else {
                        JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
                    }
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "ɾ���쳣");
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
        button.setFont(new Font("��Բ", Font.BOLD, 14));
        button.setBounds(314, 117, 93, 28);
        panel.add(button);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(AdminBTypeEdit.class.getResource("/tupian/adBG3.png")));
        lblNewLabel_1.setBounds(0, 0, 595, 413);
        jf.getContentPane().add(lblNewLabel_1);


        jf.setVisible(true);
        jf.setResizable(true);
    }
    //�������ȡ��Ϣ
    protected void typeTableMousePressed(MouseEvent evt) {
        int row = table.getSelectedRow();
        textField.setText(table.getValueAt(row, 0).toString());
        textField_1.setText(table.getValueAt(row, 1).toString());
        textField_2.setText(table.getValueAt(row, 2).toString());

    }
    private void putDates() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Connection con = null;
        try {
            con = DbUtils.getConnection();
            ResultSet list = bookTypeDao.list(con, new BookType());
            while (list.next()) {
                Vector rowData = new Vector();
                rowData.add(list.getInt("id"));
                rowData.add(list.getString("type_name"));
                rowData.add(list.getString("remark"));
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
        }

    }
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AdminBTypeEdit();
    }
}

