package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDiaLogDemo {
    public static void main(String[] args) {
        Button button1 = new Button("模态对话框");
        Button button2 = new Button("非模态对话框");

        // 创建 JFrame 对象
        JFrame frame = new JFrame("DialogDemo");
        frame.setSize(300, 200);
        frame.setLocation(300, 200);
        frame.setLayout(new FlowLayout());

        // 把 button1 和 button2 添加到 frame 中
        frame.add(button1);
        frame.add(button2);

        // 设置关闭窗口的时候，停止 jvm
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // 创建一个对话框对象
        JDialog dialog = new JDialog(frame, "Dialog");
        dialog.setSize(220, 150);
        dialog.setLocation(350, 250);
        dialog.setLayout(new FlowLayout());  // 设置布局管理器
        Button button3 = new Button("确定");
        dialog.add(button3);

        // 创建 JLabel对象 - 创建文本内容
        JLabel label = new JLabel();

        // 为模态对话框按钮 button1 添加单击事件
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {    // 当点击 button 按钮时，就会触发这个方法
                System.out.println("模态对话框按钮");
                // 将对话框设置为模态对话框
                dialog.setModal(true);
                // 判断 dialog 中是否已经添加了 label, 如果没有那么添加 label
                if (dialog.getComponents().length == 1) {   // 判断对话框中有几个组件
                    dialog.add(label);
                }
                // 设置 label 文本内容
                label.setText("模态对话框，点击确定按钮");
                // 显示对话框
                dialog.setVisible(true);
            }
        });

        // 为非模态对话框按钮 button2 添加单击事件
        button2.addActionListener((e) -> {
                System.out.println("非静态对话框按钮");
                dialog.setModal(false);
                label.setText("非模态对话框，点击确定按钮");
                dialog.setVisible(true);
            });

        // 给 button3 按钮绑定事件, 点击 button3，关闭 dialog 窗口
        button3.addActionListener((e)-> dialog.dispose());
    }
}
