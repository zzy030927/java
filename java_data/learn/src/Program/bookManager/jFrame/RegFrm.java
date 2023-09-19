package Program.bookManager.jFrame;
import org.jb2011.lnf.beautyeye.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// 密码校验的正则表达式     ^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$
                        // (?![0-9]+$) 负向前瞻断言：表示字符串不允许只包含数字
                        // (?![a-zA-Z]+$) 负向前瞻断言，表示字符串不允许只包含字母
                        // [0-9A-Za-z]{6,16} 表示数字或字母能出现 6 - 16 次
// 手机用户校验的正则表达式  ^( (13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\d[8}$

// 用户注册界面
public class RegFrm extends JFrame {
    private JFrame jf;                          // 用户注册的窗体组件
    private JLabel label;                       // 显示用户名的三个 JLabel
    private JTextField textField;               // 显示用户名文本框 JLabel
    private JLabel label_1;                     // 展示密码 2个字
    private JTextField textField_1;             // 密码文本框
    private JLabel label_2;                     // 展示手机号三个字的 JLabel
    private JTextField textField_2;             // 手机号所对应的文本框组件
    private JLabel label_3;                     // 展示性别两个字对应的 JLabel
    private JRadioButton rdbtnNewRadioButton;   // 性别男所对应的单选按钮
    private JRadioButton rdbtnNewRadioButton_1; // 性别女所对应的单选按钮
    private JLabel usernameMes;                 // 用户名校验结果对应的提示框
    private JLabel passwordMes;                 // 密码校验结果对应的提示框
    private JLabel phoneMes;                    // 手机号码校验结果对应的提示框
    private JLabel label_4;                     // 展示验证码三个字的 JLabel
    private JTextField textField_3;             // 输入验证码所对应的文本框
    private ValidCode vcode;                    // 展示验证码的图片框
    private JButton button;                     // 注册按钮
    private JButton button_1;                   // 前往登录页面的按钮
    private JLabel lblNewLabel;                 // 展示背景图片所需要的 JLabel
    private JLabel lblNewLabel_1;               // 顶部用户注册 4个字所需要的 JLabel

    public RegFrm() {
        // 初始化窗体
        jf = new JFrame("用户注册");
        jf.getContentPane().setFont(new Font("幼圆", Font.BOLD, 16)); // 获取容器的面板内容并设置字体
        jf.setBounds(600, 250, 510, 410);   // 设置窗体的大小和位置
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);

        // 初始化并显示用户名的 3个 JLabel
        label = new JLabel("用户名: ");
        label.setForeground(Color.BLACK);       // 设置前景
        label.setFont(new Font("幼圆", Font.BOLD, 16));
        label.setBounds(110, 65, 75, 40);
        jf.getContentPane().add(label);

        // 初始化用户名文本框组件
        textField = new JTextField();
        textField.setFont(new Font("幼圆", Font.BOLD, 14));
        textField.setForeground(Color.BLACK);
        textField.setColumns(10);
        textField.setBounds(198, 71, 164, 30);
        jf.getContentPane().add(textField);

        // 添加焦点监听器，当失去焦点时需要对用户名进行校验
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {     // 获取焦点

            }
            @Override
            public void focusLost(FocusEvent e) {       // 失去焦点，编写校验用户名的逻辑代码

            }
        });

        // 初始化显示密码的 JLabel
        label_1 = new JLabel("密码: ");
        label_1.setForeground(Color.BLACK);       // 设置前景
        label_1.setFont(new Font("幼圆", Font.BOLD, 16));
        label_1.setBounds(120, 108, 65, 40);
        jf.getContentPane().add(label_1);

        // 初始化密码输入框
        textField_1 = new JTextField();
        textField_1.setFont(new Font("dialog", Font.BOLD, 14));
        textField_1.setToolTipText("");
        textField_1.setColumns(10);
        textField_1.setBounds(198, 114, 164, 30);
        jf.getContentPane().add(textField_1);

        // 添加焦点监听器，当失去焦点时需要对用户名进行校验
        textField_1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {     // 获取焦点

            }
            @Override
            public void focusLost(FocusEvent e) {       // 失去焦点，编写校验用户名的逻辑代码

            }
        });

        // 初始化展示手机号的 JLabel
        label_2 = new JLabel("手机号: ");
        label_2.setForeground(Color.BLACK);       // 设置前景
        label_2.setFont(new Font("幼圆", Font.BOLD, 16));
        label_2.setBounds(110, 150, 75, 40);
        jf.getContentPane().add(label_2);

        // 初始化手机号输入框
        textField_2 = new JTextField();
        textField_2.setFont(new Font("dialog", Font.BOLD, 14));
        textField_2.setColumns(10);
        textField_2.setBounds(198, 156, 164, 30);
        jf.getContentPane().add(textField_2);

        // 添加焦点监听器，当失去焦点时需要对用户名进行校验
        textField_2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {     // 获取焦点

            }
            @Override
            public void focusLost(FocusEvent e) {       // 失去焦点，编写校验用户名的逻辑代码

            }
        });

        // 初始化性别单选按钮的相关组件
        label_3 = new JLabel("性别: ");
        label_3.setForeground(Color.BLACK);       // 设置前景
        label_3.setFont(new Font("幼圆", Font.BOLD, 16));
        label_3.setBounds(123, 184, 65, 40);
        jf.getContentPane().add(label_3);

        rdbtnNewRadioButton = new JRadioButton("男");
        rdbtnNewRadioButton.setFont(new Font("幼圆", Font.BOLD, 16));
        rdbtnNewRadioButton.setBounds(198, 192, 58, 23);
        jf.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("女");
        rdbtnNewRadioButton_1.setFont(new Font("幼圆", Font.BOLD, 16));
        rdbtnNewRadioButton_1.setBounds(198, 192, 58, 23);
        jf.getContentPane().add(rdbtnNewRadioButton_1);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtnNewRadioButton);
        bg.add(rdbtnNewRadioButton_1);

        // 初始化校验名结果提示的 JLabel
        usernameMes = new JLabel("");
        usernameMes.setFont(new Font("幼圆", Font.BOLD, 15));
        usernameMes.setBounds(372, 57, 122, 27);
        jf.getContentPane().add(usernameMes);

        // 初始化校验结果的 JLabel
        passwordMes = new JLabel("");
        passwordMes.setFont(new Font("幼圆", Font.BOLD, 15));
        passwordMes.setBounds(372, 110, 122, 27);
        jf.getContentPane().add(passwordMes);

        // 初始化手机校验结果提示的 JLabel
        phoneMes = new JLabel("");
        phoneMes.setFont(new Font("幼圆", Font.BOLD, 15));
        phoneMes.setBounds(372, 142, 122, 27);
        jf.getContentPane().add(phoneMes);

        // 展示验证码的图片框
        vcode = new ValidCode();
        vcode.setLocation(292, 231);
        jf.getContentPane().add(vcode);

        // 初始化显示验证码 3个字所需要的 JLabel
        label_4 = new JLabel("验证码: ");
        label_4.setForeground(Color.BLACK);       // 设置前景
        label_4.setFont(new Font("幼圆", Font.BOLD, 16));
        label_4.setBounds(110, 231, 75, 40);
        jf.getContentPane().add(label_4);

        // 初始化输入验证码所需要的文本框
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(198, 241, 83, 30);
        jf.getContentPane().add(textField_3);

        // 初始化注册按钮
        button = new JButton("注册");

        // 给注册按钮添加一个动作监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {      // 编写校验验证码的业务逻辑

            }
        });
        button.setFont(new Font("幼圆", Font.BOLD, 15));
        button.setBounds(120, 299, 75, 30);
        jf.getContentPane().add(button);

        // 初始化前往登陆的按钮
        button_1 = new JButton("前往登陆页面");
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {        // 编写前往登录页面的逻辑代码

            }
        });
        button.setFont(new Font("幼圆", Font.BOLD, 15));
        button.setBounds(245, 299, 132, 30);
        jf.getContentPane().add(button_1);

        // 初始化展示用户注册 4 个字所需要的 JLabel
        lblNewLabel_1 = new JLabel("用户注册");
        lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 22));
        lblNewLabel_1.setBounds(184, 10, 122, 51);
        jf.getContentPane().add(lblNewLabel_1);

        // 初始化显示注册页面背景图片所需要的 JLabel
        lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setIcon(new ImageIcon(RegFrm.class.getResource("/tupian/regBGR.png")));
        lblNewLabel.setBounds(0, 0, 494, 372);
        jf.getContentPane().add(lblNewLabel);

        // 让 jf 显示，并且不可更改 jf 的大小
        jf.setVisible(true);
        jf.setResizable(false);
    }

    // 注册页面
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
