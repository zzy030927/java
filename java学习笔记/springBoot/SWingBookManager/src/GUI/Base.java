package GUI;

import javax.swing.*;
import java.awt.*;

public class Base {
    public static void main(String[] args) {
        JFrame frame = new JFrame("学工号");     // 生成一个窗体对象
        frame.setSize(800, 600);        // 设置窗口大小
        frame.setBackground(Color.blue);             // 背景颜色
        frame.setLocation(new Point(13, 12));  // 设置窗口位置
        frame.setVisible(true);                      // 显示组件
//        frame.add(Component comp);                 // 像容器中添加组件
//        frame.setLayout(LayoutManager manager);    // 设置一个布局管理器
//        frame.pack();                              // 调整窗口大小，适应子组件的大小和布局
        frame.getContentPane();                      // 返回窗口的容器对象
    }
}
