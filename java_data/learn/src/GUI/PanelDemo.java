package GUI;

import javax.swing.*;
import java.awt.*;

// ������
public class PanelDemo {
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Panel");
        frame.setLayout(new BorderLayout());
        frame.setSize(350, 200);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ����һ�� JScrollPane ����
        JScrollPane scrollPane = new JScrollPane();

        // ����ˮƽ����������
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // ���ô�ֱ����������
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // ����һ�� JPane ����
        JPanel panel = new JPanel();

        // ����ĸ���ť���
        panel.add(new JButton("��ť1"));
        panel.add(new JButton("��ť2"));
        panel.add(new JButton("��ť2"));
        panel.add(new JButton("��ť4"));

        // �� panel ���ø� JScrollPane
        scrollPane.setViewportView(panel);

        // �� JScrollPane ��ӵ� JFrame ��
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PanelDemo::createAndShowGUI);
    }
}
