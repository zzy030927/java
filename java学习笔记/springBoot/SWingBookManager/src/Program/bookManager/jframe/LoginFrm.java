package Program.bookManager.jframe;

import Program.bookManager.dao.UserDao;
import Program.bookManager.model.User;
import Program.bookManager.utils.*;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class LoginFrm extends JFrame {
    public static User currentUser;         // ����½�ɹ���ʹ�øñ����洢��½���û�
    private JFrame jf;                      // ��¼����Ĵ������
    private JTextField userNameText;        // �����û������ı������
    private JTextField passwordText;        // ����������ı������
    private JComboBox<String> comboBox;     // �û���ɫ�����������

    UserDao userDao = new UserDao();
    public LoginFrm(){
        jf = new JFrame("ͼ�����");
        jf.getContentPane().setFont(new Font("��Բ", Font.BOLD, 14));
        jf.setBounds(600, 250, 500, 467);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel(new ImageIcon(LoginFrm.class.getResource("/tupian/bg2.png")));
        lblNewLabel.setBounds(24, 10, 430, 218);
        jf.getContentPane().add(lblNewLabel);

        JLabel label = new JLabel("�û�����");
        label.setFont(new Font("��Բ", Font.BOLD, 14));
        label.setBounds(129, 250, 60, 29);
        jf.getContentPane().add(label);

        userNameText = new JTextField();
        userNameText.setBounds(199, 252, 127, 25);
        jf.getContentPane().add(userNameText);
        userNameText.setColumns(10);

        JLabel label_1 = new JLabel("���룺");
        label_1.setFont(new Font("��Բ", Font.BOLD, 14));
        label_1.setBounds(144, 289, 45, 29);
        jf.getContentPane().add(label_1);

        passwordText = new JPasswordField();
        passwordText.setColumns(10);
        passwordText.setBounds(199, 291, 127, 25);
        jf.getContentPane().add(passwordText);

        JLabel label_2 = new JLabel("Ȩ�ޣ�");
        label_2.setFont(new Font("��Բ", Font.BOLD, 14));
        label_2.setBounds(144, 328, 45, 29);
        jf.getContentPane().add(label_2);

        comboBox = new JComboBox();
        comboBox.setBounds(199, 332, 127, 25);
        comboBox.addItem("�û�");
        comboBox.addItem("����Ա");
        jf.getContentPane().add(comboBox);

        JButton button = new JButton("��¼");
        // �û���¼��ҵ���߼�
        button.addActionListener(e -> checkLogin(e));
        button.setBounds(153, 377, 65, 29);
        jf.getContentPane().add(button);

        JButton button_1 = new JButton("ע��");
        button_1.addActionListener((e) -> regUser(e));
        button_1.setBounds(263, 377, 65, 29);
        jf.getContentPane().add(button_1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/tupian/adBG3.png")));
        lblNewLabel_1.setBounds(0, 0, 484, 429);
        jf.getContentPane().add(lblNewLabel_1);

        jf.setVisible(true);
        jf.setResizable(true);

    }
    protected void regUser(ActionEvent e) {
        jf.setVisible(false);
        new RegFrm();
    }
    protected void checkLogin(ActionEvent e) {
        String userName = userNameText.getText();
        String password = passwordText.getText();
        int index = comboBox.getSelectedIndex();
        if (ToolUtils.isEmpty(userName) || ToolUtils.isEmpty(password)) {
            JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ��");
            return;
        }
        // ��¼�û���������ʹ�õ� user ����
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        if (index == 0) {
            user.setRole(1);
        } else {
            user.setRole(2);
        }
        Connection connection = null;
        try {
            connection = DbUtils.getConnection();
            User login = userDao.login(connection, user);
            currentUser = login;
            if (login == null) {
                JOptionPane.showMessageDialog(null, "��¼ʧ��");
            } else {
                // Ȩ�� 1��ͨ 2����Ա
                if (index == 0) {
                    // ѧ��
                    jf.dispose();
                    new UserMenuFrm();
                } else {
                    // ����Ա
                    jf.dispose();
                    new AdminMenuFrm();
                }
            }
        } catch (Exception e21) {
            e21.printStackTrace();
            JOptionPane.showMessageDialog(null, "��¼�쳣");
        } finally {
            try {
                DbUtils.closeConnection(connection);
            } catch (Exception e31) {
                e31.printStackTrace();
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
        new LoginFrm();
    }
}
