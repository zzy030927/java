package GUI;

import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;

// ���ֹ�����
public class LayoutDemo {
    // ��ʽ���ֹ�����
    @Test
    public void FlowLayoutDemo() throws InterruptedException {
        // 1. ���� JFrame ����
        JFrame frame = new JFrame("FlowLayout");
        // 2. ������ʽ����
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));   // ���������λ�ã�ˮƽ��࣬��ֱ���

        // ��Ӱ�ť
        Button button = null;
        for (int i = 0; i < 9; i++) {
            button = new Button("��ť" + i);
            frame.add(button);
        }

        // ���� frame ��С
        frame.setSize(280, 250);
        frame.setVisible(true);
        Thread.sleep(10000);
    }

    // �߽粼�ֹ�����
    @Test
    public void BorderLayoutDemo() throws InterruptedException {
        JFrame frame = new JFrame("BorderLayout");
        frame.setSize(300, 200);
        frame.setLocation(300, 200);
        // ���ò��ֹ�����Ϊ BorderLayout
        frame.setLayout(new BorderLayout(3, 3));
        // ��Ӱ�ť���
        frame.add(new JButton("North"), BorderLayout.NORTH);
        frame.add(new JButton("South"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);
        frame.setVisible(true);
        Thread.sleep(10000);
    }

    // ���񲼾ֹ�����
    @Test
    public void GridLayoutDemo() throws InterruptedException {
        JFrame frame = new JFrame("GridLayout");
        frame.setSize(300, 300);
        frame.setLocation(400, 300);
        frame.setLayout(new GridLayout(3, 3));
        JButton button;
        for (int i = 0; i < 9; i++) {
            button = new JButton("��ť" + i);
            frame.add(button);
        }
        frame.setVisible(true);

        Thread.sleep(10000);
    }

    @Test
    public void GridBagLayout() throws InterruptedException {
        JFrame frame = new JFrame("GridBagLayout");
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        frame.setLayout(gridBagLayout);

        // �� constrains ����������Կ���Լ������
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        // ��Ӱ�ť���
        // ��һ��
        addComponent("button1", gridBagLayout, constraints, frame);
        addComponent("button2", gridBagLayout, constraints, frame);
        addComponent("button3", gridBagLayout, constraints, frame);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        addComponent("button4", gridBagLayout, constraints, frame);

        // ����Ȩ��
        // �ڶ���
        constraints.weightx = 0;
        constraints.weighty = 0;
        addComponent("button5", gridBagLayout, constraints, frame);

        // ������
        constraints.gridwidth = 1;  // ���һ��
        addComponent("button6", gridBagLayout, constraints, frame);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        addComponent("button7", gridBagLayout, constraints, frame);

        // ��� button8
        constraints.gridheight = 2; // ������������Ԫ��
        constraints.gridwidth = 1;  // ������һ����Ԫ��
        constraints.weightx = 2;
        constraints.weighty = 2;
        addComponent("button8", gridBagLayout, constraints, frame);

        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = 1;
        addComponent("button9", gridBagLayout, constraints, frame);
        addComponent("button10", gridBagLayout, constraints, frame);

        frame.setSize(800, 800);
        frame.setVisible(true);

        Thread.sleep(10000);
    }

    // ��Ӱ�ť�������ط���
    private static void addComponent(String name, GridBagLayout gridBagLayout, GridBagConstraints constraints, JFrame frame) {
        JButton button = new JButton(name);
        gridBagLayout.setConstraints(button, constraints);
        frame.add(button);
    }
}
