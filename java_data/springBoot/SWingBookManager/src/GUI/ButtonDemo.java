package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo {
    public static void createAndShowGUI1() {
        JFrame frame = new JFrame("按钮组件");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建 JLabel 对象
        JLabel label = new JLabel("hello world!", JLabel.CENTER);
        label.setFont(new Font("宋体", Font.PLAIN, 20));

        // 创建一个 JPanel 对象
        JPanel panel = new JPanel();

        // 创建复选框对象
        JCheckBox jCheckBox = new JCheckBox("ITALIC");
        JCheckBox bold = new JCheckBox("bold");


        // 创建一个 ActionListener 对象
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 定义一个 int 类型的变量，记录字体的样式
                int mode = 0;
                if (bold.isSelected()) {
                    mode += Font.BOLD;
                }
                if (jCheckBox.isSelected()) {
                    mode += Font.ITALIC;
                }

                // 给 Label 重新设置字体
                label.setFont(new Font("宋体", mode, 20));
            }
        };
        // 给复选框添加事件
        jCheckBox.addActionListener(listener);
        bold.addActionListener(listener);

        // 把复选框添加到 panel 中
        panel.add(jCheckBox);
        panel.add(bold);

        // 把 JPanel 和 JLabel 添加到 frame 中
        frame.add(label);
        frame.add(panel, BorderLayout.PAGE_END);
    }

    public static void createAndShowGUI2() {
        JFrame frame = new JFrame("按钮组件");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建 JLabel 对象
        JLabel label = new JLabel("hello world!", JLabel.CENTER);
        label.setFont(new Font("宋体", Font.PLAIN, 20));

        // 创建一个 JPanel 对象
        JPanel panel = new JPanel();

        // 创建复选框对象
        JRadioButton jRadioButton = new JRadioButton("ITALIC");
        JRadioButton bold = new JRadioButton("bold");
        // 创建一个按钮组
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton);
        buttonGroup.add(bold);


        // 创建一个 ActionListener 对象
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 定义一个 int 类型的变量，记录字体的样式
                int mode = 0;
                if (bold.isSelected()) {
                    mode += Font.BOLD;
                }
                if (jRadioButton.isSelected()) {
                    mode += Font.ITALIC;
                }

                // 给 Label 重新设置字体
                label.setFont(new Font("宋体", mode, 20));
            }
        };
        // 给复选框添加事件
        jRadioButton.addActionListener(listener);
        bold.addActionListener(listener);

        // 把复选框添加到 panel 中
        panel.add(jRadioButton);
        panel.add(bold);

        // 把 JPanel 和 JLabel 添加到 frame 中
        frame.add(label);
        frame.add(panel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ButtonDemo::createAndShowGUI2);   // 用于将该方法加入到事件调度线程
    }
}
