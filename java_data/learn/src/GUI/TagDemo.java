package GUI;

import javax.swing.*;
import java.awt.*;

// 标签组件
public class TagDemo {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Tag窗口");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建 JLabel 对象
        JLabel label1 = new JLabel();
        ImageIcon icon = new ImageIcon("hello.webp");
        Image image = icon.getImage();
        // 设置 image 的属性
        image.getScaledInstance(300, 150, Image.SCALE_DEFAULT); // 第三个参数为算法类型
        icon.setImage(image);   // 重新设置 image
        label1.setIcon(icon);
        label1.setHorizontalAlignment(SwingConstants.CENTER);   // 设置水平对齐
                                                                // setVerticalAlignment() 垂直方向对齐

        // 创建一个 JPanel 对象
        JPanel panel = new JPanel();
        JLabel label2 = new JLabel("欢迎进入水果超市", JLabel.CENTER);
        panel.add(label2);

        // 把 label1 和 panel 添加到 frame 中
        frame.add(label1, BorderLayout.PAGE_START);
        frame.add(panel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TagDemo::createAndShowGUI);
    }
}
