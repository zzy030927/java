package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JComboBoxDemo {
    // ���������
    public static void createAndShowGUI1() {
        JFrame frame = new JFrame("������");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ����һ�� JPanel ����
        JPanel panel = new JPanel();

        // ����һ��������
        JComboBox<String> comboBox = new JComboBox<>();

        // �������ѡ��
        comboBox.addItem("��ѡ�����");
        comboBox.addItem("����");
        comboBox.addItem("���");
        comboBox.addItem("�ӱ�");
        comboBox.addItem("�Ϻ�");
        comboBox.addItem("ɽ��");

        // ���� JTextField ����
        JTextField field = new JTextField(20);

        // �� JComboBoxȥ��Ӷ���������
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ��ȡѡ�е�����ѡ��
                String item = (String) comboBox.getSelectedItem();
                if ("��ѡ�����".equals(item)) {
                    field.setText("");
                } else {
                    field.setText("��ѡ��ĳ����ǣ�" + item);
                }
            }
        });
        // �� JComboBox �� JTextField ��ӵ� JPanel
        panel.add(comboBox);
        panel.add(field);

        // �� JPanel ��ӵ� JFrame
        frame.add(panel, BorderLayout.PAGE_START);
    }


    // ����ʽ�˵�
    public static void createAndShowGUI2() {
        JFrame frame = new JFrame("������");
        frame.setSize(350, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ����һ���˵���
        JMenuBar menuBar = new JMenuBar();

        // �����˵�
        JMenu menu1 = new JMenu("�ļ�(F)");
        JMenu menu2 = new JMenu("����(H)");
        menuBar.add(menu1);
        menuBar.add(menu2);

        // �����˵���
        JMenuItem item1 = new JMenuItem("�½�(N)");
        JMenuItem item2 = new JMenuItem("�ر�(X)");
        menu1.add(item1);
        menu1.addSeparator();   // ��ӷָ���
        menu1.add(item2);

        // ���˵��� ��Ӷ���������
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ����һ���Ի���
                JDialog dialog = new JDialog(frame, "�ޱ���", true);
                dialog.setSize(200, 100);
                dialog.setLocation(300, 200);
                dialog.setVisible(true);
                dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // �� JMenuBar ��ӵ� JFrame ��
        frame.setJMenuBar(menuBar);

    }

    // ����ʽ�˵�
    public static void createAndShowGUI3() {
        JFrame frame = new JFrame("����ʽ�˵�");
        frame.setSize(350, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ����һ������ʽ�˵�
        JPopupMenu menu = new JPopupMenu();
        // �����˵���
        JMenuItem item1 = new JMenuItem("�鿴");
        JMenuItem item2 = new JMenuItem("ˢ��");
        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);

        // �� JFrame �����������
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // �ж��û������갸���Ƿ�Ϊ�Ҽ�
                if (e.getButton() == MouseEvent.BUTTON3) {
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JComboBoxDemo::createAndShowGUI3);
    }
}
