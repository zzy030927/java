package GUI;

import javax.swing.*;
import java.awt.*;

public class Base {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ѧ����");     // ����һ���������
        frame.setSize(800, 600);        // ���ô��ڴ�С
        frame.setBackground(Color.blue);             // ������ɫ
        frame.setLocation(new Point(13, 12));  // ���ô���λ��
        frame.setVisible(true);                      // ��ʾ���
//        frame.add(Component comp);                 // ��������������
//        frame.setLayout(LayoutManager manager);    // ����һ�����ֹ�����
//        frame.pack();                              // �������ڴ�С����Ӧ������Ĵ�С�Ͳ���
        frame.getContentPane();                      // ���ش��ڵ���������
    }
}
