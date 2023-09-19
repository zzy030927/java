package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDiaLogDemo {
    public static void main(String[] args) {
        Button button1 = new Button("ģ̬�Ի���");
        Button button2 = new Button("��ģ̬�Ի���");

        // ���� JFrame ����
        JFrame frame = new JFrame("DialogDemo");
        frame.setSize(300, 200);
        frame.setLocation(300, 200);
        frame.setLayout(new FlowLayout());

        // �� button1 �� button2 ��ӵ� frame ��
        frame.add(button1);
        frame.add(button2);

        // ���ùرմ��ڵ�ʱ��ֹͣ jvm
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // ����һ���Ի������
        JDialog dialog = new JDialog(frame, "Dialog");
        dialog.setSize(220, 150);
        dialog.setLocation(350, 250);
        dialog.setLayout(new FlowLayout());  // ���ò��ֹ�����
        Button button3 = new Button("ȷ��");
        dialog.add(button3);

        // ���� JLabel���� - �����ı�����
        JLabel label = new JLabel();

        // Ϊģ̬�Ի���ť button1 ��ӵ����¼�
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    // ����� button ��ťʱ���ͻᴥ���������
                System.out.println("ģ̬�Ի���ť");
                // ���Ի�������Ϊģ̬�Ի���
                dialog.setModal(true);
                // �ж� dialog ���Ƿ��Ѿ������ label, ���û����ô��� label
                if (dialog.getComponents().length == 1) {   // �ж϶Ի������м������
                    dialog.add(label);
                }
                // ���� label �ı�����
                label.setText("ģ̬�Ի��򣬵��ȷ����ť");
                // ��ʾ�Ի���
                dialog.setVisible(true);
            }
        });

        // Ϊ��ģ̬�Ի���ť button2 ��ӵ����¼�
        button2.addActionListener((e) -> {
                System.out.println("�Ǿ�̬�Ի���ť");
                dialog.setModal(false);
                label.setText("��ģ̬�Ի��򣬵��ȷ����ť");
                dialog.setVisible(true);
            });

        // �� button3 ��ť���¼�, ��� button3���ر� dialog ����
        button3.addActionListener((e)-> dialog.dispose());
    }
}
