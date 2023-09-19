package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 文本组件
public class JTextDemo {
    public static void main(String[] args) {
        // 创建一个 JFrame
        JFrame frame = new JFrame("聊天窗口");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 300);
        frame.setLocation(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建文本域
        JTextArea showArea = new JTextArea(12, 34);

        // 创建一个滚动条面板对象
        JScrollPane scrollPane = new JScrollPane(showArea);
        showArea.setEditable(false);    // 设置文本域不可编辑

        // 创建一个 JTextField 文本框
        JTextField inputField = new JTextField(20);
        JButton button = new JButton("发送");
        JLabel label = new JLabel("聊天信息");// 展示文本内容

        // 给按钮添加事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取文本框中的内容
                String text = inputField.getText();

                // 判断该内容
                if (!text.trim().equals("")) {
                    // 给文本域添加内容
                    showArea.append("本人输入信息：" + text + "\n");
                } else {
                    showArea.append("聊天信息不能为空\n");
                }
                // 清空文本框内容
                inputField.setText("");
            }

        });

        // 创建 JPanel 对象
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputField);
        panel.add(button);

        // 把 JScrollPane 和 JPanel 添加到 JFrame 中
        frame.add(scrollPane, BorderLayout.PAGE_START);
        frame.add(panel, BorderLayout.PAGE_END);

    }
}
