package Program.bookManager.jframe;
import Program.bookManager.dao.BookTypeDao;
import Program.bookManager.model.BookType;
import Program.bookManager.utils.DbUtils;
import Program.bookManager.utils.ToolUtils;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class AdminMenuFrm extends JFrame {
    private JFrame jf;              // ����������Ӧ�Ĵ���
    private JTextField textField;   // ���������������Ҫ���ı������
    private JButton btnNewButton;   // ��Ӱ�ť
    private JTextArea textArea;     // ��������ϸ��Ϣ����Ҫ���ı������
    BookTypeDao bookTypeDao = new BookTypeDao();
    public AdminMenuFrm(){
        jf=new JFrame("����Ա����");
        jf.setBounds(400, 100, 600, 429);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        JLabel label = new JLabel();
        label.setFont(new Font("��Բ", Font.BOLD, 14));
        label.setText("���˵����");
        label.setBounds(112, 107, 75, 26);
        jf.getContentPane().add(label);

        JLabel label_1 = new JLabel();
        label_1.setFont(new Font("��Բ", Font.BOLD, 14));
        label_1.setText("������ƣ�");
        label_1.setBounds(112, 38, 75, 26);
        jf.getContentPane().add(label_1);

        textField = new JTextField();
        textField.setBounds(197, 38, 241, 26);
        jf.getContentPane().add(textField);

        btnNewButton = new JButton("���");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {        // ��д��ӵ�ҵ���߼�����
                // ��ȡ�������ƻ�������˵������
                String typeName = textField.getText();
                String typeRemark = textArea.getText();
                // �ж�����
                if (ToolUtils.isEmpty(typeName) || ToolUtils.isEmpty(typeRemark)) {
                    JOptionPane.showMessageDialog(null, "�����������Ϣ");
                    return;
                }
                // �����ݷ�װ��һ�� BookType����
                BookType bookType = new BookType();
                bookType.setTypeName(typeName);
                bookType.setRemark(typeRemark);
                Connection con = null;
                try {
                    // �����ݱ��浽���ݿ���
                    con = DbUtils.getConnection();
                    int i = bookTypeDao.add(con, bookType);
                    if (i == 1) {
                        JOptionPane.showMessageDialog(null, "��ӳɹ�");
                        reset();
                    }else if(i == 2){
                        JOptionPane.showMessageDialog(null, "���ʧ��,����Ѵ���");
                    } else {
                        JOptionPane.showMessageDialog(null, "���ʧ��");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }finally{
                    try {
                        DbUtils.closeConnection(con);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        btnNewButton.setFont(new Font("��Բ", Font.BOLD, 14));
        btnNewButton.setBounds(182, 281, 80, 26);
        jf.getContentPane().add(btnNewButton);

        // �������ð�ť
        JButton button = new JButton("����");
        button.addActionListener(new ActionListener() {         // ���õ�ҵ���߼�����
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        button.setFont(new Font("��Բ", Font.BOLD, 14));
        button.setBounds(360, 281, 80, 26);
        jf.getContentPane().add(button);

        textArea = new JTextArea();
        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setBackground(Color.WHITE);
        textArea.setBounds(197, 109, 241, 132);
        jf.getContentPane().add(textArea);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(AdminMenuFrm.class.getResource("/tupian/adBG2.png")));
        lblNewLabel.setBounds(0, 0, 584, 370);
        jf.getContentPane().add(lblNewLabel);

        // �����˵������
        JMenuBar menuBar = new JMenuBar();
        jf.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("������");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("������");
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("����޸�");
        mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {// ��д����޸�ҵ��ִ���߼�����
                jf.dispose();
                new AdminBTypeEdit();
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_2 = new JMenu("�鼮����");
        menuBar.add(mnNewMenu_2);

        // ����鼮��Ӳ˵���
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("�鼮���");
        mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {  // ��д�鼮���ҵ���߼��������
                jf.dispose();
                new AdminBookAdd();
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_2);

        // ����鼮�޸Ĳ˵���
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("�鼮�޸�");
        mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {  // ��д�鼮�޸�ҵ���߼��������
                jf.dispose();
                new AdminBookEdit();
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_3);

        // ����û�����˵�
        JMenu menu1 = new JMenu("�û�����");
        menuBar.add(menu1);

        // ����û���Ϣ�˵���
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("�û���Ϣ");
        mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {// ��д�û���Ϣҵ���߼��������
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminUserInfo();
            }
        });
        menu1.add(mntmNewMenuItem_4);

        // ��ӽ�����Ϣ�˵���
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("������Ϣ");
        mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {          // ��д������Ϣ�˵�����ҵ���߼��������
                jf.dispose();
                new AdminBorrowInfo();
            }
        });
        menu1.add(mntmNewMenuItem_5);

        // ����˳�ϵͳ�˵�
        JMenu mnNewMenu_1 = new JMenu("�˳�ϵͳ");
        mnNewMenu_1.addMouseListener(new MouseAdapter() {       // ����˳�ϵͳҵ���߼�����
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
        textArea.setText("");
    }
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AdminMenuFrm();
    }
}
