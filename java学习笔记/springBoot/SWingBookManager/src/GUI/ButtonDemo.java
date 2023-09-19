package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo {
    public static void createAndShowGUI1() {
        JFrame frame = new JFrame("��ť���");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ���� JLabel ����
        JLabel label = new JLabel("hello world!", JLabel.CENTER);
        label.setFont(new Font("����", Font.PLAIN, 20));

        // ����һ�� JPanel ����
        JPanel panel = new JPanel();

        // ������ѡ�����
        JCheckBox jCheckBox = new JCheckBox("ITALIC");
        JCheckBox bold = new JCheckBox("bold");


        // ����һ�� ActionListener ����
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ����һ�� int ���͵ı�������¼�������ʽ
                int mode = 0;
                if (bold.isSelected()) {
                    mode += Font.BOLD;
                }
                if (jCheckBox.isSelected()) {
                    mode += Font.ITALIC;
                }

                // �� Label ������������
                label.setFont(new Font("����", mode, 20));
            }
        };
        // ����ѡ������¼�
        jCheckBox.addActionListener(listener);
        bold.addActionListener(listener);

        // �Ѹ�ѡ����ӵ� panel ��
        panel.add(jCheckBox);
        panel.add(bold);

        // �� JPanel �� JLabel ��ӵ� frame ��
        frame.add(label);
        frame.add(panel, BorderLayout.PAGE_END);
    }

    public static void createAndShowGUI2() {
        JFrame frame = new JFrame("��ť���");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ���� JLabel ����
        JLabel label = new JLabel("hello world!", JLabel.CENTER);
        label.setFont(new Font("����", Font.PLAIN, 20));

        // ����һ�� JPanel ����
        JPanel panel = new JPanel();

        // ������ѡ�����
        JRadioButton jRadioButton = new JRadioButton("ITALIC");
        JRadioButton bold = new JRadioButton("bold");
        // ����һ����ť��
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton);
        buttonGroup.add(bold);


        // ����һ�� ActionListener ����
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ����һ�� int ���͵ı�������¼�������ʽ
                int mode = 0;
                if (bold.isSelected()) {
                    mode += Font.BOLD;
                }
                if (jRadioButton.isSelected()) {
                    mode += Font.ITALIC;
                }

                // �� Label ������������
                label.setFont(new Font("����", mode, 20));
            }
        };
        // ����ѡ������¼�
        jRadioButton.addActionListener(listener);
        bold.addActionListener(listener);

        // �Ѹ�ѡ����ӵ� panel ��
        panel.add(jRadioButton);
        panel.add(bold);

        // �� JPanel �� JLabel ��ӵ� frame ��
        frame.add(label);
        frame.add(panel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ButtonDemo::createAndShowGUI2);   // ���ڽ��÷������뵽�¼������߳�
    }
}
