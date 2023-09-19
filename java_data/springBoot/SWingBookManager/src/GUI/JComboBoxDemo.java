package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JComboBoxDemo {
    // 下拉框组件
    public static void createAndShowGUI1() {
        JFrame frame = new JFrame("下拉框");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个 JPanel 对象
        JPanel panel = new JPanel();

        // 创建一个下拉框
        JComboBox<String> comboBox = new JComboBox<>();

        // 添加下拉选项
        comboBox.addItem("请选择城市");
        comboBox.addItem("北京");
        comboBox.addItem("天津");
        comboBox.addItem("河北");
        comboBox.addItem("上海");
        comboBox.addItem("山东");

        // 创建 JTextField 对象
        JTextField field = new JTextField(20);

        // 给 JComboBox去添加动作监听器
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取选中的下拉选项
                String item = (String) comboBox.getSelectedItem();
                if ("请选择城市".equals(item)) {
                    field.setText("");
                } else {
                    field.setText("您选择的城市是：" + item);
                }
            }
        });
        // 把 JComboBox 和 JTextField 添加到 JPanel
        panel.add(comboBox);
        panel.add(field);

        // 把 JPanel 添加到 JFrame
        frame.add(panel, BorderLayout.PAGE_START);
    }


    // 下拉式菜单
    public static void createAndShowGUI2() {
        JFrame frame = new JFrame("下拉框");
        frame.setSize(350, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个菜单栏
        JMenuBar menuBar = new JMenuBar();

        // 创建菜单
        JMenu menu1 = new JMenu("文件(F)");
        JMenu menu2 = new JMenu("帮助(H)");
        menuBar.add(menu1);
        menuBar.add(menu2);

        // 创建菜单项
        JMenuItem item1 = new JMenuItem("新建(N)");
        JMenuItem item2 = new JMenuItem("关闭(X)");
        menu1.add(item1);
        menu1.addSeparator();   // 添加分隔符
        menu1.add(item2);

        // 给菜单项 添加动作监听器
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建一个对话框
                JDialog dialog = new JDialog(frame, "无标题", true);
                dialog.setSize(200, 100);
                dialog.setLocation(300, 200);
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // 把 JMenuBar 添加到 JFrame 中
        frame.setJMenuBar(menuBar);

    }

    // 弹出式菜单
    public static void createAndShowGUI3() {
        JFrame frame = new JFrame("弹出式菜单");
        frame.setSize(350, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个弹出式菜单
        JPopupMenu menu = new JPopupMenu();
        // 创建菜单项
        JMenuItem item1 = new JMenuItem("查看");
        JMenuItem item2 = new JMenuItem("刷新");
        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);

        // 给 JFrame 添加鼠标监听器
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 判断用户点击鼠标案件是否为右键
                if (e.getButton() == MouseEvent.BUTTON3) {
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JComboBoxDemo::createAndShowGUI3);
    }
}
