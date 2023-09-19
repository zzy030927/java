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
    private JFrame jf;                              // 用户注册的窗体组件
    private JLabel label;                           // 展示 `用户名` 这三个字的 JLabel
    private JTextField textField;                   // 用户名 后面跟随的文本框
    private JLabel label_1;                         // 展示 `密码` 这两个字的 JLabel
    private JTextField textField_1;                 // 密码 后面跟随的文本框
    private JLabel label_2;                         // 展示 `手机号` 这三个字的 JLabel
    private JTextField textField_2;                 // 手机号 后面跟随的文本框
    private JLabel label_3;                         // 展示  `性别` 两个字的 JLabel
    private JRadioButton rdbtnNewRadioButton;       // 性别 `男` 对应的单选按钮
    private JRadioButton rdbtnNewRadioButton_1;     // 性别 `女` 对应的单选按钮

    private JLabel usernameMes;                     // 用户名校验结果对应的提示框
    private JLabel passwordMes;                     // 密码校验结果 对应的提示框
    private JLabel phoneMes;                        // 手机号码校验结果对应的提示框

    private JLabel label_4;                         // 展示 `验证码` 三个字的 JLabel
    private JTextField textField_3;                 // 输入 验证码 所对应的提示框
    private ValidCode vcode;                        // 展示验证码的提示框
    private JButton button;                         // 注册按钮
    private JButton button_1;                       // 前往登陆页面的按钮

    private JLabel lblNewLabel;                     // 展示背景图片所需要的 JLabel
    private JLabel lblNewLabel_1;                   // 顶部 `用户注册` 四个字所需要的 JLabel
    // 创建 UserDao 的对象
    private UserDao userDao = new UserDao();

    public RegFrm() {
        jf = new JFrame("用户注册");
        jf.getContentPane().setFont(new Font("幼圆", Font.BOLD, 16));
        jf.setBounds(600, 250, 510, 410);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        label = new JLabel("用户名：");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("幼圆", Font.BOLD, 16));
        label.setBounds(110, 65, 75, 40);
        jf.getContentPane().add(label);

        textField = new JTextField();
        textField.setFont(new Font("幼圆", Font.BOLD, 14));
        textField.setForeground(Color.BLACK);
        textField.setColumns(10);
        textField.setBounds(198, 71, 164, 30);
        jf.getContentPane().add(textField);

        // 用户名文本框的监听器
        textField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {   // 失去焦点，即光标不在当前文本框内
                String text = textField.getText();
                if (ToolUtils.isEmpty(text)) {
                    usernameMes.setText("用户名不能为空");
                    usernameMes.setForeground(Color.RED);
                } else {
                    usernameMes.setText("√");
                    usernameMes.setForeground(Color.GREEN);
                }
            }
        });

        label_1 = new JLabel("密码：");
        label_1.setForeground(Color.BLACK);
        label_1.setFont(new Font("幼圆", Font.BOLD, 16));
        label_1.setBounds(120, 108, 65, 40);
        jf.getContentPane().add(label_1);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Dialog", Font.BOLD, 14));
        textField_1.setToolTipText("");
        textField_1.setColumns(10);
        textField_1.setBounds(198, 114, 164, 30);
        jf.getContentPane().add(textField_1);

        // 密码文本框的监听器
        textField_1.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                String pwd = textField_1.getText();
                if (ToolUtils.isEmpty(pwd)) {
                    passwordMes.setText("密码不能为空");
                    passwordMes.setForeground(Color.RED);
                } else {
                    boolean flag = pwd.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
                    if (flag) {
                        passwordMes.setText("√");
                        passwordMes.setForeground(Color.GREEN);
                    } else {
                        // 第一个参数为 副组件， 第二个参数为文本信息
                        JOptionPane.showMessageDialog(null, "密码需为6-16位数字和字母的组合");
                        passwordMes.setText("");
                    }
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
            }
        });

        label_2 = new JLabel("手机号：");
        label_2.setForeground(Color.BLACK);
        label_2.setFont(new Font("幼圆", Font.BOLD, 16));
        label_2.setBounds(110, 150, 75, 40);
        jf.getContentPane().add(label_2);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Dialog", Font.BOLD, 14));
        textField_2.setColumns(10);
        textField_2.setBounds(198, 156, 164, 30);
        jf.getContentPane().add(textField_2);

        // 手机号文本框的监听器
        textField_2.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                String phone = textField_2.getText();
                if (ToolUtils.isEmpty(phone)) {
                    phoneMes.setText("手机号不能为空");
                    phoneMes.setForeground(Color.RED);
                } else {
                    boolean flag = phone.matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
                    if (flag) {
                        phoneMes.setText("√");
                        phoneMes.setForeground(Color.GREEN);
                    } else {
                        JOptionPane.showMessageDialog(null, "请输入正确的手机号格式");
                        phoneMes.setText("");
                    }
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
            }
        });

        label_3 = new JLabel("性别：");
        label_3.setForeground(Color.BLACK);
        label_3.setFont(new Font("幼圆", Font.BOLD, 16));
        label_3.setBounds(123, 184, 65, 40);
        jf.getContentPane().add(label_3);

        rdbtnNewRadioButton = new JRadioButton("男");
        rdbtnNewRadioButton.setFont(new Font("幼圆", Font.BOLD, 16));
        rdbtnNewRadioButton.setBounds(198, 192, 58, 23);
        jf.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("女");
        rdbtnNewRadioButton_1.setFont(new Font("幼圆", Font.BOLD, 16));
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

        // 展示验证码的图片框
        vcode = new ValidCode();
        vcode.setLocation(293, 231);
        jf.getContentPane().add(vcode);

        label_4 = new JLabel("验证码：");
        label_4.setForeground(Color.BLACK);
        label_4.setFont(new Font("幼圆", Font.BOLD, 16));
        label_4.setBounds(110, 231, 75, 40);
        jf.getContentPane().add(label_4);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(198, 241, 83, 30);
        jf.getContentPane().add(textField_3);

        button = new JButton("注册");
        // 注册按钮的 监听器
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 校验验证码是否正确
                String code = textField_3.getText();
                if (ToolUtils.isEmpty(code)) {
                    JOptionPane.showMessageDialog(null, "请输入验证码");
                } else if (code.equals(vcode.getCode())) {  // 校验通过
                    // 完成用户的注册操作
                    regCheck();
                } else {
                    JOptionPane.showMessageDialog(null, "验证码输入错误，请重新输入");
                    vcode.nextCode();
                }
            }
        });
        button.setFont(new Font("幼圆", Font.BOLD, 15));
        button.setBounds(120, 299, 75, 30);
        jf.getContentPane().add(button);

        button_1 = new JButton("前往登录页面");
        // 前往登录按钮的 监听器
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_1.setFont(new Font("幼圆", Font.BOLD, 15));
        button_1.setBounds(245, 299, 132, 30);
        jf.getContentPane().add(button_1);

        lblNewLabel_1 = new JLabel("用户注册");
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
    // 完成用户注册
    public void regCheck() {
        // 获取相关组件的数据
        String userName = textField.getText();
        String pwd = textField_1.getText();
        String phone = textField_2.getText();
        String sex = rdbtnNewRadioButton.isSelected() ? rdbtnNewRadioButton.getText() : rdbtnNewRadioButton_1.getText();

        // 判断是否可以注册
        if (ToolUtils.isEmpty(userName) || ToolUtils.isEmpty(pwd) || ToolUtils.isEmpty(phone)) {
            JOptionPane.showMessageDialog(null, "输入信息有误");
            return;
        }
        // 把数据封装到 User 对象中
        User user = new User();
        user.setUserName(userName);
        user.setPassword(pwd);
        user.setPhone(phone);
        user.setSex(sex);
        user.setRole(1);    // 普通用户

        // 获取连接对象
        Connection connection = DbUtils.getConnection();
        int i = userDao.addUser(connection, user);      // 添加用户的同时查看用户是否已经存在
        if (i == 2) {
            JOptionPane.showMessageDialog(null, "用户已存在，请重新注册");
        } else if (i == 0) {
            JOptionPane.showMessageDialog(null, "注册失败");
        } else {
            JOptionPane.showMessageDialog(null, "注册成功");
            jf.dispose();       // 注册成功，关闭当前 frame
            new LoginFrm();     // 跳转到登陆页面
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
