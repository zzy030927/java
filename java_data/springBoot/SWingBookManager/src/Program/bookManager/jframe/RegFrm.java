package Program.bookManager.jframe;

import Program.bookManager.dao.UserDao;
import Program.bookManager.model.User;
import Program.bookManager.utils.DbUtils;
import Program.bookManager.utils.ToolUtils;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;

public class RegFrm extends JFrame {
    private JFrame jf;                              // �û�ע��Ĵ������
    private JLabel label;                           // չʾ `�û���` �������ֵ� JLabel
    private JTextField textField;                   // �û��� ���������ı���
    private JLabel label_1;                         // չʾ `����` �������ֵ� JLabel
    private JTextField textField_1;                 // ���� ���������ı���
    private JLabel label_2;                         // չʾ `�ֻ���` �������ֵ� JLabel
    private JTextField textField_2;                 // �ֻ��� ���������ı���
    private JLabel label_3;                         // չʾ  `�Ա�` �����ֵ� JLabel
    private JRadioButton rdbtnNewRadioButton;       // �Ա� `��` ��Ӧ�ĵ�ѡ��ť
    private JRadioButton rdbtnNewRadioButton_1;     // �Ա� `Ů` ��Ӧ�ĵ�ѡ��ť

    private JLabel usernameMes;                     // �û���У������Ӧ����ʾ��
    private JLabel passwordMes;                     // ����У���� ��Ӧ����ʾ��
    private JLabel phoneMes;                        // �ֻ�����У������Ӧ����ʾ��

    private JLabel label_4;                         // չʾ `��֤��` �����ֵ� JLabel
    private JTextField textField_3;                 // ���� ��֤�� ����Ӧ����ʾ��
    private ValidCode vcode;                        // չʾ��֤�����ʾ��
    private JButton button;                         // ע�ᰴť
    private JButton button_1;                       // ǰ����½ҳ��İ�ť

    private JLabel lblNewLabel;                     // չʾ����ͼƬ����Ҫ�� JLabel
    private JLabel lblNewLabel_1;                   // ���� `�û�ע��` �ĸ�������Ҫ�� JLabel
    // ���� UserDao �Ķ���
    private UserDao userDao = new UserDao();

    public RegFrm() {
        jf = new JFrame("�û�ע��");
        jf.getContentPane().setFont(new Font("��Բ", Font.BOLD, 16));
        jf.setBounds(600, 250, 510, 410);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        label = new JLabel("�û�����");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("��Բ", Font.BOLD, 16));
        label.setBounds(110, 65, 75, 40);
        jf.getContentPane().add(label);

        textField = new JTextField();
        textField.setFont(new Font("��Բ", Font.BOLD, 14));
        textField.setForeground(Color.BLACK);
        textField.setColumns(10);
        textField.setBounds(198, 71, 164, 30);
        jf.getContentPane().add(textField);

        // �û����ı���ļ�����
        textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {   // ʧȥ���㣬����겻�ڵ�ǰ�ı�����
                String text = textField.getText();
                if (ToolUtils.isEmpty(text)) {
                    usernameMes.setText("�û�������Ϊ��");
                    usernameMes.setForeground(Color.RED);
                } else {
                    usernameMes.setText("��");
                    usernameMes.setForeground(Color.GREEN);
                }
            }
        });

        label_1 = new JLabel("���룺");
        label_1.setForeground(Color.BLACK);
        label_1.setFont(new Font("��Բ", Font.BOLD, 16));
        label_1.setBounds(120, 108, 65, 40);
        jf.getContentPane().add(label_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Dialog", Font.BOLD, 14));
        textField_1.setToolTipText("");
        textField_1.setColumns(10);
        textField_1.setBounds(198, 114, 164, 30);
        jf.getContentPane().add(textField_1);

        // �����ı���ļ�����
        textField_1.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                String pwd = textField_1.getText();
                if (ToolUtils.isEmpty(pwd)) {
                    passwordMes.setText("���벻��Ϊ��");
                    passwordMes.setForeground(Color.RED);
                } else {
                    boolean flag = pwd.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
                    if (flag) {
                        passwordMes.setText("��");
                        passwordMes.setForeground(Color.GREEN);
                    } else {
                        // ��һ������Ϊ ������� �ڶ�������Ϊ�ı���Ϣ
                        JOptionPane.showMessageDialog(null, "������Ϊ6-16λ���ֺ���ĸ�����");
                        passwordMes.setText("");
                    }
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
            }
        });

        label_2 = new JLabel("�ֻ��ţ�");
        label_2.setForeground(Color.BLACK);
        label_2.setFont(new Font("��Բ", Font.BOLD, 16));
        label_2.setBounds(110, 150, 75, 40);
        jf.getContentPane().add(label_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Dialog", Font.BOLD, 14));
        textField_2.setColumns(10);
        textField_2.setBounds(198, 156, 164, 30);
        jf.getContentPane().add(textField_2);

        // �ֻ����ı���ļ�����
        textField_2.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                String phone = textField_2.getText();
                if (ToolUtils.isEmpty(phone)) {
                    phoneMes.setText("�ֻ��Ų���Ϊ��");
                    phoneMes.setForeground(Color.RED);
                } else {
                    boolean flag = phone.matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
                    if (flag) {
                        phoneMes.setText("��");
                        phoneMes.setForeground(Color.GREEN);
                    } else {
                        JOptionPane.showMessageDialog(null, "��������ȷ���ֻ��Ÿ�ʽ");
                        phoneMes.setText("");
                    }
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
            }
        });

        label_3 = new JLabel("�Ա�");
        label_3.setForeground(Color.BLACK);
        label_3.setFont(new Font("��Բ", Font.BOLD, 16));
        label_3.setBounds(123, 184, 65, 40);
        jf.getContentPane().add(label_3);

        rdbtnNewRadioButton = new JRadioButton("��");
        rdbtnNewRadioButton.setFont(new Font("��Բ", Font.BOLD, 16));
        rdbtnNewRadioButton.setBounds(198, 192, 58, 23);
        jf.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("Ů");
        rdbtnNewRadioButton_1.setFont(new Font("��Բ", Font.BOLD, 16));
        rdbtnNewRadioButton_1.setBounds(287, 192, 65, 23);
        jf.getContentPane().add(rdbtnNewRadioButton_1);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtnNewRadioButton_1);
        bg.add(rdbtnNewRadioButton);

        usernameMes = new JLabel("");
        usernameMes.setFont(new Font("Dialog", Font.BOLD, 15));
        usernameMes.setBounds(372, 57, 122, 27);
        jf.getContentPane().add(usernameMes);

        passwordMes = new JLabel("");
        passwordMes.setFont(new Font("Dialog", Font.BOLD, 15));
        passwordMes.setBounds(372, 100, 122, 27);
        jf.getContentPane().add(passwordMes);

        phoneMes = new JLabel("");
        phoneMes.setFont(new Font("Dialog", Font.BOLD, 15));
        phoneMes.setBounds(372, 142, 122, 30);
        jf.getContentPane().add(phoneMes);

        // չʾ��֤���ͼƬ��
        vcode = new ValidCode();
        vcode.setLocation(293, 231);
        jf.getContentPane().add(vcode);

        label_4 = new JLabel("��֤�룺");
        label_4.setForeground(Color.BLACK);
        label_4.setFont(new Font("��Բ", Font.BOLD, 16));
        label_4.setBounds(110, 231, 75, 40);
        jf.getContentPane().add(label_4);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(198, 241, 83, 30);
        jf.getContentPane().add(textField_3);

        button = new JButton("ע��");
        // ע�ᰴť�� ������
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // У����֤���Ƿ���ȷ
                String code = textField_3.getText();
                if (ToolUtils.isEmpty(code)) {
                    JOptionPane.showMessageDialog(null, "��������֤��");
                } else if (code.equals(vcode.getCode())) {  // У��ͨ��
                    // ����û���ע�����
                    regCheck();
                } else {
                    JOptionPane.showMessageDialog(null, "��֤�������������������");
                    vcode.nextCode();
                }
            }
        });
        button.setFont(new Font("��Բ", Font.BOLD, 15));
        button.setBounds(120, 299, 75, 30);
        jf.getContentPane().add(button);

        button_1 = new JButton("ǰ����¼ҳ��");
        // ǰ����¼��ť�� ������
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_1.setFont(new Font("��Բ", Font.BOLD, 15));
        button_1.setBounds(245, 299, 132, 30);
        jf.getContentPane().add(button_1);

        lblNewLabel_1 = new JLabel("�û�ע��");
        lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 22));

        lblNewLabel_1.setBounds(184, 10, 122, 51);
        jf.getContentPane().add(lblNewLabel_1);

        lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setIcon(new ImageIcon(RegFrm.class.getResource("/tupian/regBG.png")));
        lblNewLabel.setBounds(0, 0, 494, 372);
        jf.getContentPane().add(lblNewLabel);

        jf.setVisible(true);
        jf.setResizable(true);
    }
    // ����û�ע��
    public void regCheck() {
        // ��ȡ������������
        String userName = textField.getText();
        String pwd = textField_1.getText();
        String phone = textField_2.getText();
        String sex = rdbtnNewRadioButton.isSelected() ? rdbtnNewRadioButton.getText() : rdbtnNewRadioButton_1.getText();

        // �ж��Ƿ����ע��
        if (ToolUtils.isEmpty(userName) || ToolUtils.isEmpty(pwd) || ToolUtils.isEmpty(phone)) {
            JOptionPane.showMessageDialog(null, "������Ϣ����");
            return;
        }
        // �����ݷ�װ�� User ������
        User user = new User();
        user.setUserName(userName);
        user.setPassword(pwd);
        user.setPhone(phone);
        user.setSex(sex);
        user.setRole(1);    // ��ͨ�û�

        // ��ȡ���Ӷ���
        Connection connection = DbUtils.getConnection();
        int i = userDao.addUser(connection, user);      // ����û���ͬʱ�鿴�û��Ƿ��Ѿ�����
        if (i == 2) {
            JOptionPane.showMessageDialog(null, "�û��Ѵ��ڣ�������ע��");
        } else if (i == 0) {
            JOptionPane.showMessageDialog(null, "ע��ʧ��");
        } else {
            JOptionPane.showMessageDialog(null, "ע��ɹ�");
            jf.dispose();       // ע��ɹ����رյ�ǰ frame
            new LoginFrm();     // ��ת����½ҳ��
        }
        DbUtils.closeConnection(connection);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new RegFrm();
    }
}
