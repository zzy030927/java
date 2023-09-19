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
        // 给窗体添加监听器
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened....窗体打开事件");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing....窗体正在关闭事件");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed....窗体已经关闭事件");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified....窗体最小化事件");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified....窗体取消最小化事件");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated....窗体激活事件");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated....窗体停用事件");
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

        // 给鼠标添加一个监听器
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked....鼠标完成点击事件");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)        // 鼠标左键
                    System.out.println("MouseLeft....鼠标左键摁下");
                else if (e.getButton() == MouseEvent.BUTTON2)   // 鼠标滚轮
                    System.out.println("MouseMid....鼠标滚轮摁下");
                else                                            // 鼠标右键
                    System.out.println("MouseRight....鼠标右键摁下");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased....鼠标已松开");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered....鼠标进入按钮区域事件");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited....鼠标移除按钮区域事件");
            }
        });
    }

    public static void keyboardEventDemo() {
        JFrame frame = new JFrame("MouseEvent");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 300);
        frame.setLocation(300, 200);

        // 创建一个 JTextField
        JTextField field = new JTextField(30);
        frame.add(field);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.addKeyListener(new KeyAdapter() {    // 抽象类 KeyAdapter,实现了 KeyListener,但是方法体为空，要实现那个方法，只需重写它即可。
            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                System.out.println("键盘已摁下的字符内容为: " + keyChar);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventDemo::keyboardEventDemo);
    }

}
