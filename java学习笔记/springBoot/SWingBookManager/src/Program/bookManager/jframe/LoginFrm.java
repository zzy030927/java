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
    public static User currentUser;         // 当登陆成功后，使用该变量存储登陆的用户
    private JFrame jf;                      // 登录界面的窗体组件
    private JTextField userNameText;        // 输入用户名的文本框组件
    private JTextField passwordText;        // 输入密码的文本框组件
    private JComboBox<String> comboBox;     // 用户角色的下拉框组件

    UserDao userDao = new UserDao();
    public LoginFrm(){
        jf = new JFrame("图书管理");
        jf.getContentPane().setFont(new Font("幼圆", Font.BOLD, 14));
        jf.setBounds(600, 250, 500, 467);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel(new ImageIcon(LoginFrm.class.getResource("/tupian/bg2.png")));
        lblNewLabel.setBounds(24, 10, 430, 218);
        jf.getContentPane().add(lblNewLabel);

        JLabel label = new JLabel("用户名：");
        label.setFont(new Font("幼圆", Font.BOLD, 14));
        label.setBounds(129, 250, 60, 29);
        jf.getContentPane().add(label);

        userNameText = new JTextField();
        userNameText.setBounds(199, 252, 127, 25);
        jf.getContentPane().add(userNameText);
        userNameText.setColumns(10);

        JLabel label_1 = new JLabel("密码：");
        label_1.setFont(new Font("幼圆", Font.BOLD, 14));
        label_1.setBounds(144, 289, 45, 29);
        jf.getContentPane().add(label_1);

        passwordText = new JPasswordField();
        passwordText.setColumns(10);
        passwordText.setBounds(199, 291, 127, 25);
        jf.getContentPane().add(passwordText);

        JLabel label_2 = new JLabel("权限：");
        label_2.setFont(new Font("幼圆", Font.BOLD, 14));
        label_2.setBounds(144, 328, 45, 29);
        jf.getContentPane().add(label_2);

        comboBox = new JComboBox();
        comboBox.setBounds(199, 332, 127, 25);
        comboBox.addItem("用户");
        comboBox.addItem("管理员");
        jf.getContentPane().add(comboBox);

        JButton button = new JButton("登录");
        // 用户登录的业务逻辑
        button.addActionListener(e -> checkLogin(e));
        button.setBounds(153, 377, 65, 29);
        jf.getContentPane().add(button);

        JButton button_1 = new JButton("注册");
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
            JOptionPane.showMessageDialog(null, "用户名和密码不能为空");
            return;
        }
        // 登录用户名、密码使用的 user 对象
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
                JOptionPane.showMessageDialog(null, "登录失败");
            } else {
                // 权限 1普通 2管理员
                if (index == 0) {
                    // 学生
                    jf.dispose();
                    new UserMenuFrm();
                } else {
                    // 管理员
                    jf.dispose();
                    new AdminMenuFrm();
                }
            }
        } catch (Exception e21) {
            e21.printStackTrace();
            JOptionPane.showMessageDialog(null, "登录异常");
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
