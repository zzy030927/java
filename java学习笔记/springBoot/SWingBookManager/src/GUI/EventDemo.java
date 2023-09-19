package GUI;

import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventDemo {
    @Test
    public void createAndShowGUI() throws InterruptedException {
        JFrame frame = new JFrame("WindowEvent");
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrame frame2 = new JFrame("22222");
        frame2.setSize(100, 100);
        frame2.setVisible(true);
        // ��������Ӽ�����
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened....������¼�");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing....�������ڹر��¼�");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed....�����Ѿ��ر��¼�");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified....������С���¼�");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified....����ȡ����С���¼�");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated....���弤���¼�");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated....����ͣ���¼�");
            }
        });
        Thread.sleep(5000);
    }

    public static void mouseEventDemo() {
        JFrame frame = new JFrame("MouseEvent");
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Button");
        frame.add(button);

        // ��������һ��������
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked....�����ɵ���¼�");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)        // ������
                    System.out.println("MouseLeft....����������");
                else if (e.getButton() == MouseEvent.BUTTON2)   // ������
                    System.out.println("MouseMid....����������");
                else                                            // ����Ҽ�
                    System.out.println("MouseRight....����Ҽ�����");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased....������ɿ�");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered....�����밴ť�����¼�");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited....����Ƴ���ť�����¼�");
            }
        });
    }

    public static void keyboardEventDemo() {
        JFrame frame = new JFrame("MouseEvent");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 300);
        frame.setLocation(300, 200);

        // ����һ�� JTextField
        JTextField field = new JTextField(30);
        frame.add(field);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.addKeyListener(new KeyAdapter() {    // ������ KeyAdapter,ʵ���� KeyListener,���Ƿ�����Ϊ�գ�Ҫʵ���Ǹ�������ֻ����д�����ɡ�
            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                System.out.println("���������µ��ַ�����Ϊ: " + keyChar);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventDemo::keyboardEventDemo);
    }

}
