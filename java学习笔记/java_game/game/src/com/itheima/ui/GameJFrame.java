package com.itheima.ui;

import javax.swing.*;

public class GameJFrame extends JFrame
{
    // JFrame 界面，窗体
    // 子类也表示界面，窗体
    public GameJFrame()
    {
        // 设置界面的长和宽
        // this 表示当前调用者的地址值
        this.setSize(603, 680);
        // 是否显示界面，这里默认为 false
        this.setVisible(true);
    }
}
