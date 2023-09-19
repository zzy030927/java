package GUI;

import java.awt.event.*;
import javax.swing.*;

// 自定义事件监听器类
class MyListener implements ActionListener {
    // 实现监听器方法，对监听事件进行处理
    public void actionPerformed(ActionEvent e) {
        System.out.println("用户点击了JButton按钮组件");
    }
}

public class Example07 {
    private static void createAndShowGUI() {
        JFrame f = new JFrame("JFrame窗口");
        f.setSize(200, 100);
        // 创建一个按钮组件，作为事件源
        JButton btn = new JButton("按钮");
        // 为按钮组件事件源添加自定义监听器
        btn.addActionListener(new MyListener());
        f.add(btn);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // 使用 SwingUtilities 工具类调用 createAndShowGUI()方法并显示GUI程序
        SwingUtilities.invokeLater(Example07::createAndShowGUI);
    }
}
