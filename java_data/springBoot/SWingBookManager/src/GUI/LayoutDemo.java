package GUI;

import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;

// 布局管理器
public class LayoutDemo {
    // 流式布局管理器
    @Test
    public void FlowLayoutDemo() throws InterruptedException {
        // 1. 创建 JFrame 对象
        JFrame frame = new JFrame("FlowLayout");
        // 2. 设置流式布局
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));   // 参数：组件位置，水平间距，垂直间距

        // 添加按钮
        Button button = null;
        for (int i = 0; i < 9; i++) {
            button = new Button("按钮" + i);
            frame.add(button);
        }

        // 设置 frame 大小
        frame.setSize(280, 250);
        frame.setVisible(true);
        Thread.sleep(10000);
    }

    // 边界布局管理器
    @Test
    public void BorderLayoutDemo() throws InterruptedException {
        JFrame frame = new JFrame("BorderLayout");
        frame.setSize(300, 200);
        frame.setLocation(300, 200);
        // 设置布局管理器为 BorderLayout
        frame.setLayout(new BorderLayout(3, 3));
        // 添加按钮组件
        frame.add(new JButton("North"), BorderLayout.NORTH);
        frame.add(new JButton("South"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);
        frame.setVisible(true);
        Thread.sleep(10000);
    }

    // 网格布局管理器
    @Test
    public void GridLayoutDemo() throws InterruptedException {
        JFrame frame = new JFrame("GridLayout");
        frame.setSize(300, 300);
        frame.setLocation(400, 300);
        frame.setLayout(new GridLayout(3, 3));
        JButton button;
        for (int i = 0; i < 9; i++) {
            button = new JButton("按钮" + i);
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

        // 给 constrains 设置相关属性控制约束条件
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        // 添加按钮组件
        // 第一行
        addComponent("button1", gridBagLayout, constraints, frame);
        addComponent("button2", gridBagLayout, constraints, frame);
        addComponent("button3", gridBagLayout, constraints, frame);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        addComponent("button4", gridBagLayout, constraints, frame);

        // 更改权重
        // 第二行
        constraints.weightx = 0;
        constraints.weighty = 0;
        addComponent("button5", gridBagLayout, constraints, frame);

        // 第三行
        constraints.gridwidth = 1;  // 横跨一列
        addComponent("button6", gridBagLayout, constraints, frame);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        addComponent("button7", gridBagLayout, constraints, frame);

        // 添加 button8
        constraints.gridheight = 2; // 纵向横跨两个单元格
        constraints.gridwidth = 1;  // 横向横跨一个单元格
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

    // 添加按钮组件的相关方法
    private static void addComponent(String name, GridBagLayout gridBagLayout, GridBagConstraints constraints, JFrame frame) {
        JButton button = new JButton(name);
        gridBagLayout.setConstraints(button, constraints);
        frame.add(button);
    }
}
