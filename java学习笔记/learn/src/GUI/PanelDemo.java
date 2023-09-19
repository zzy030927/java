package GUI;

import javax.swing.*;
import java.awt.*;

// 面板组件
public class PanelDemo {
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Panel");
        frame.setLayout(new BorderLayout());
        frame.setSize(350, 200);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个 JScrollPane 对象
        JScrollPane scrollPane = new JScrollPane();

        // 设置水平滚动条策略
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // 设置垂直滚动条策略
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // 创建一个 JPane 对象
        JPanel panel = new JPanel();

        // 添加四个按钮组件
        panel.add(new JButton("按钮1"));
        panel.add(new JButton("按钮2"));
        panel.add(new JButton("按钮2"));
        panel.add(new JButton("按钮4"));

        // 把 panel 设置给 JScrollPane
        scrollPane.setViewportView(panel);

        // 把 JScrollPane 添加到 JFrame 中
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PanelDemo::createAndShowGUI);
    }
}
