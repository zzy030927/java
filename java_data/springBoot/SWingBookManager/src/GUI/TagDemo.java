package GUI;

import javax.swing.*;
import java.awt.*;

// ��ǩ���
public class TagDemo {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Tag����");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ���� JLabel ����
        JLabel label1 = new JLabel();
        ImageIcon icon = new ImageIcon("hello.webp");
        Image image = icon.getImage();
        // ���� image ������
        image.getScaledInstance(300, 150, Image.SCALE_DEFAULT); // ����������Ϊ�㷨����
        icon.setImage(image);   // �������� image
        label1.setIcon(icon);
        label1.setHorizontalAlignment(SwingConstants.CENTER);   // ����ˮƽ����
                                                                // setVerticalAlignment() ��ֱ�������

        // ����һ�� JPanel ����
        JPanel panel = new JPanel();
        JLabel label2 = new JLabel("��ӭ����ˮ������", JLabel.CENTER);
        panel.add(label2);

        // �� label1 �� panel ��ӵ� frame ��
        frame.add(label1, BorderLayout.PAGE_START);
        frame.add(panel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TagDemo::createAndShowGUI);
    }
}
