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
    private JFrame jf;              // 主界面所对应的窗体
    private JTextField textField;   // 输入类别名称所需要的文本框组件
    private JButton btnNewButton;   // 添加按钮
    private JTextArea textArea;     // 输入类详细信息所需要的文本域组件
    BookTypeDao bookTypeDao = new BookTypeDao();
    public AdminMenuFrm(){
        jf=new JFrame("管理员界面");
        jf.setBounds(400, 100, 600, 429);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setLayout(null);

        JLabel label = new JLabel();
        label.setFont(new Font("幼圆", Font.BOLD, 14));
        label.setText("类别说明：");
        label.setBounds(112, 107, 75, 26);
        jf.getContentPane().add(label);

        JLabel label_1 = new JLabel();
        label_1.setFont(new Font("幼圆", Font.BOLD, 14));
        label_1.setText("类别名称：");
        label_1.setBounds(112, 38, 75, 26);
        jf.getContentPane().add(label_1);

        textField = new JTextField();
        textField.setBounds(197, 38, 241, 26);
        jf.getContentPane().add(textField);

        btnNewButton = new JButton("添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {        // 编写添加的业务逻辑代码
                // 获取类别的名称还有类别的说明数据
                String typeName = textField.getText();
                String typeRemark = textArea.getText();
                // 判断数据
                if (ToolUtils.isEmpty(typeName) || ToolUtils.isEmpty(typeRemark)) {
                    JOptionPane.showMessageDialog(null, "请输入相关信息");
                    return;
                }
                // 把数据封装到一个 BookType对象
                BookType bookType = new BookType();
                bookType.setTypeName(typeName);
                bookType.setRemark(typeRemark);
                Connection con = null;
                try {
                    // 把数据保存到数据库中
                    con = DbUtils.getConnection();
                    int i = bookTypeDao.add(con, bookType);
                    if (i == 1) {
                        JOptionPane.showMessageDialog(null, "添加成功");
                        reset();
                    }else if(i == 2){
                        JOptionPane.showMessageDialog(null, "添加失败,类别已存在");
                    } else {
                        JOptionPane.showMessageDialog(null, "添加失败");
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
        btnNewButton.setFont(new Font("幼圆", Font.BOLD, 14));
        btnNewButton.setBounds(182, 281, 80, 26);
        jf.getContentPane().add(btnNewButton);

        // 创建重置按钮
        JButton button = new JButton("重置");
        button.addActionListener(new ActionListener() {         // 重置的业务逻辑代码
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        button.setFont(new Font("幼圆", Font.BOLD, 14));
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

        // 创建菜单栏组件
        JMenuBar menuBar = new JMenuBar();
        jf.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("类别管理");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("类别添加");
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("类别修改");
        mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {// 编写类别修改业务执行逻辑代码
                jf.dispose();
                new AdminBTypeEdit();
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_2 = new JMenu("书籍管理");
        menuBar.add(mnNewMenu_2);

        // 添加书籍添加菜单项
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("书籍添加");
        mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {  // 编写书籍添加业务逻辑处理代码
                jf.dispose();
                new AdminBookAdd();
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_2);

        // 添加书籍修改菜单项
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("书籍修改");
        mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {  // 编写书籍修改业务逻辑处理代码
                jf.dispose();
                new AdminBookEdit();
            }
        });
        mnNewMenu_2.add(mntmNewMenuItem_3);

        // 添加用户管理菜单
        JMenu menu1 = new JMenu("用户管理");
        menuBar.add(menu1);

        // 添加用户信息菜单项
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("用户信息");
        mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {// 编写用户信息业务逻辑处理代码
            public void mousePressed(MouseEvent evt) {
                jf.dispose();
                new AdminUserInfo();
            }
        });
        menu1.add(mntmNewMenuItem_4);

        // 添加借阅信息菜单项
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("借阅信息");
        mntmNewMenuItem_5.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {          // 编写借阅信息菜单栏项业务逻辑处理代码
                jf.dispose();
                new AdminBorrowInfo();
            }
        });
        menu1.add(mntmNewMenuItem_5);

        // 添加退出系统菜单
        JMenu mnNewMenu_1 = new JMenu("退出系统");
        mnNewMenu_1.addMouseListener(new MouseAdapter() {       // 添加退出系统业务逻辑代码
            public void mousePressed(MouseEvent evt) {
                JOptionPane.showMessageDialog(null, "欢迎再次使用");
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
