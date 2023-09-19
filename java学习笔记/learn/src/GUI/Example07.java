package GUI;

import java.awt.event.*;
import javax.swing.*;

// �Զ����¼���������
class MyListener implements ActionListener {
    // ʵ�ּ������������Լ����¼����д���
    public void actionPerformed(ActionEvent e) {
        System.out.println("�û������JButton��ť���");
    }
}

public class Example07 {
    private static void createAndShowGUI() {
        JFrame f = new JFrame("JFrame����");
        f.setSize(200, 100);
        // ����һ����ť�������Ϊ�¼�Դ
        JButton btn = new JButton("��ť");
        // Ϊ��ť����¼�Դ����Զ��������
        btn.addActionListener(new MyListener());
        f.add(btn);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // ʹ�� SwingUtilities ��������� createAndShowGUI()��������ʾGUI����
        SwingUtilities.invokeLater(Example07::createAndShowGUI);
    }
}
