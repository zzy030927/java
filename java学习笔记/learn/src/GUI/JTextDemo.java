package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// �ı����
public class JTextDemo {
    public static void main(String[] args) {
        // ����һ�� JFrame
        JFrame frame = new JFrame("���촰��");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 300);
        frame.setLocation(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // �����ı���
        JTextArea showArea = new JTextArea(12, 34);

        // ����һ��������������
        JScrollPane scrollPane = new JScrollPane(showArea);
        showArea.setEditable(false);    // �����ı��򲻿ɱ༭

        // ����һ�� JTextField �ı���
        JTextField inputField = new JTextField(20);
        JButton button = new JButton("����");
        JLabel label = new JLabel("������Ϣ");// չʾ�ı�����

        // ����ť����¼�
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ��ȡ�ı����е�����
                String text = inputField.getText();

                // �жϸ�����
                if (!text.trim().equals("")) {
                    // ���ı����������
                    showArea.append("����������Ϣ��" + text + "\n");
                } else {
                    showArea.append("������Ϣ����Ϊ��\n");
                }
                // ����ı�������
                inputField.setText("");
            }

        });

        // ���� JPanel ����
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputField);
        panel.add(button);

        // �� JScrollPane �� JPanel ��ӵ� JFrame ��
        frame.add(scrollPane, BorderLayout.PAGE_START);
        frame.add(panel, BorderLayout.PAGE_END);

    }
}
