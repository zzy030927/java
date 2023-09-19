package Program.bookManager.jFrame;
import org.jb2011.lnf.beautyeye.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// ����У���������ʽ     ^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$
                        // (?![0-9]+$) ����ǰհ���ԣ���ʾ�ַ���������ֻ��������
                        // (?![a-zA-Z]+$) ����ǰհ���ԣ���ʾ�ַ���������ֻ������ĸ
                        // [0-9A-Za-z]{6,16} ��ʾ���ֻ���ĸ�ܳ��� 6 - 16 ��
// �ֻ��û�У���������ʽ  ^( (13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d[8}$

// �û�ע�����
public class RegFrm extends JFrame {
    private JFrame jf;                          // �û�ע��Ĵ������
    private JLabel label;                       // ��ʾ�û��������� JLabel
    private JTextField textField;               // ��ʾ�û����ı��� JLabel
    private JLabel label_1;                     // չʾ���� 2����
    private JTextField textField_1;             // �����ı���
    private JLabel label_2;                     // չʾ�ֻ��������ֵ� JLabel
    private JTextField textField_2;             // �ֻ�������Ӧ���ı������
    private JLabel label_3;                     // չʾ�Ա������ֶ�Ӧ�� JLabel
    private JRadioButton rdbtnNewRadioButton;   // �Ա�������Ӧ�ĵ�ѡ��ť
    private JRadioButton rdbtnNewRadioButton_1; // �Ա�Ů����Ӧ�ĵ�ѡ��ť
    private JLabel usernameMes;                 // �û���У������Ӧ����ʾ��
    private JLabel passwordMes;                 // ����У������Ӧ����ʾ��
    private JLabel phoneMes;                    // �ֻ�����У������Ӧ����ʾ��
    private JLabel label_4;                     // չʾ��֤�������ֵ� JLabel
    private JTextField textField_3;             // ������֤������Ӧ���ı���
    private ValidCode vcode;                    // չʾ��֤���ͼƬ��
    private JButton button;                     // ע�ᰴť
    private JButton button_1;                   // ǰ����¼ҳ��İ�ť
    private JLabel lblNewLabel;                 // չʾ����ͼƬ����Ҫ�� JLabel
    private JLabel lblNewLabel_1;               // �����û�ע�� 4��������Ҫ�� JLabel

    public RegFrm() {
        // ��ʼ������
        jf = new JFrame("�û�ע��");
        jf.getContentPane().setFont(new Font("��Բ", Font.BOLD, 16)); // ��ȡ������������ݲ���������
        jf.setBounds(600, 250, 510, 410);   // ���ô���Ĵ�С��λ��
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);

        // ��ʼ������ʾ�û����� 3�� JLabel
        label = new JLabel("�û���: ");
        label.setForeground(Color.BLACK);       // ����ǰ��
        label.setFont(new Font("��Բ", Font.BOLD, 16));
        label.setBounds(110, 65, 75, 40);
        jf.getContentPane().add(label);

        // ��ʼ���û����ı������
        textField = new JTextField();
        textField.setFont(new Font("��Բ", Font.BOLD, 14));
        textField.setForeground(Color.BLACK);
        textField.setColumns(10);
        textField.setBounds(198, 71, 164, 30);
        jf.getContentPane().add(textField);

        // ��ӽ������������ʧȥ����ʱ��Ҫ���û�������У��
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {     // ��ȡ����

            }
            @Override
            public void focusLost(FocusEvent e) {       // ʧȥ���㣬��дУ���û������߼�����

            }
        });

        // ��ʼ����ʾ����� JLabel
        label_1 = new JLabel("����: ");
        label_1.setForeground(Color.BLACK);       // ����ǰ��
        label_1.setFont(new Font("��Բ", Font.BOLD, 16));
        label_1.setBounds(120, 108, 65, 40);
        jf.getContentPane().add(label_1);

        // ��ʼ�����������
        textField_1 = new JTextField();
        textField_1.setFont(new Font("dialog", Font.BOLD, 14));
        textField_1.setToolTipText("");
        textField_1.setColumns(10);
        textField_1.setBounds(198, 114, 164, 30);
        jf.getContentPane().add(textField_1);

        // ��ӽ������������ʧȥ����ʱ��Ҫ���û�������У��
        textField_1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {     // ��ȡ����

            }
            @Override
            public void focusLost(FocusEvent e) {       // ʧȥ���㣬��дУ���û������߼�����

            }
        });

        // ��ʼ��չʾ�ֻ��ŵ� JLabel
        label_2 = new JLabel("�ֻ���: ");
        label_2.setForeground(Color.BLACK);       // ����ǰ��
        label_2.setFont(new Font("��Բ", Font.BOLD, 16));
        label_2.setBounds(110, 150, 75, 40);
        jf.getContentPane().add(label_2);

        // ��ʼ���ֻ��������
        textField_2 = new JTextField();
        textField_2.setFont(new Font("dialog", Font.BOLD, 14));
        textField_2.setColumns(10);
        textField_2.setBounds(198, 156, 164, 30);
        jf.getContentPane().add(textField_2);

        // ��ӽ������������ʧȥ����ʱ��Ҫ���û�������У��
        textField_2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {     // ��ȡ����

            }
            @Override
            public void focusLost(FocusEvent e) {       // ʧȥ���㣬��дУ���û������߼�����

            }
        });

        // ��ʼ���Ա�ѡ��ť��������
        label_3 = new JLabel("�Ա�: ");
        label_3.setForeground(Color.BLACK);       // ����ǰ��
        label_3.setFont(new Font("��Բ", Font.BOLD, 16));
        label_3.setBounds(123, 184, 65, 40);
        jf.getContentPane().add(label_3);

        rdbtnNewRadioButton = new JRadioButton("��");
        rdbtnNewRadioButton.setFont(new Font("��Բ", Font.BOLD, 16));
        rdbtnNewRadioButton.setBounds(198, 192, 58, 23);
        jf.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("Ů");
        rdbtnNewRadioButton_1.setFont(new Font("��Բ", Font.BOLD, 16));
        rdbtnNewRadioButton_1.setBounds(198, 192, 58, 23);
        jf.getContentPane().add(rdbtnNewRadioButton_1);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtnNewRadioButton);
        bg.add(rdbtnNewRadioButton_1);

        // ��ʼ��У���������ʾ�� JLabel
        usernameMes = new JLabel("");
        usernameMes.setFont(new Font("��Բ", Font.BOLD, 15));
        usernameMes.setBounds(372, 57, 122, 27);
        jf.getContentPane().add(usernameMes);

        // ��ʼ��У������ JLabel
        passwordMes = new JLabel("");
        passwordMes.setFont(new Font("��Բ", Font.BOLD, 15));
        passwordMes.setBounds(372, 110, 122, 27);
        jf.getContentPane().add(passwordMes);

        // ��ʼ���ֻ�У������ʾ�� JLabel
        phoneMes = new JLabel("");
        phoneMes.setFont(new Font("��Բ", Font.BOLD, 15));
        phoneMes.setBounds(372, 142, 122, 27);
        jf.getContentPane().add(phoneMes);

        // չʾ��֤���ͼƬ��
        vcode = new ValidCode();
        vcode.setLocation(292, 231);
        jf.getContentPane().add(vcode);

        // ��ʼ����ʾ��֤�� 3��������Ҫ�� JLabel
        label_4 = new JLabel("��֤��: ");
        label_4.setForeground(Color.BLACK);       // ����ǰ��
        label_4.setFont(new Font("��Բ", Font.BOLD, 16));
        label_4.setBounds(110, 231, 75, 40);
        jf.getContentPane().add(label_4);

        // ��ʼ��������֤������Ҫ���ı���
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(198, 241, 83, 30);
        jf.getContentPane().add(textField_3);

        // ��ʼ��ע�ᰴť
        button = new JButton("ע��");

        // ��ע�ᰴť���һ������������
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {      // ��дУ����֤���ҵ���߼�

            }
        });
        button.setFont(new Font("��Բ", Font.BOLD, 15));
        button.setBounds(120, 299, 75, 30);
        jf.getContentPane().add(button);

        // ��ʼ��ǰ����½�İ�ť
        button_1 = new JButton("ǰ����½ҳ��");
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {        // ��дǰ����¼ҳ����߼�����

            }
        });
        button.setFont(new Font("��Բ", Font.BOLD, 15));
        button.setBounds(245, 299, 132, 30);
        jf.getContentPane().add(button_1);

        // ��ʼ��չʾ�û�ע�� 4 ��������Ҫ�� JLabel
        lblNewLabel_1 = new JLabel("�û�ע��");
        lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 22));
        lblNewLabel_1.setBounds(184, 10, 122, 51);
        jf.getContentPane().add(lblNewLabel_1);

        // ��ʼ����ʾע��ҳ�汳��ͼƬ����Ҫ�� JLabel
        lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setIcon(new ImageIcon(RegFrm.class.getResource("/tupian/regBGR.png")));
        lblNewLabel.setBounds(0, 0, 494, 372);
        jf.getContentPane().add(lblNewLabel);

        // �� jf ��ʾ�����Ҳ��ɸ��� jf �Ĵ�С
        jf.setVisible(true);
        jf.setResizable(false);
    }

    // ע��ҳ��
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        new RegFrm();
    }
}
