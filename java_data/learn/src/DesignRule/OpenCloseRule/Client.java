package DesignRule.OpenCloseRule;

public class Client // Client 客户端
{
    public static void main(String[] args) {
        // 1.创建搜狗输入类对象
        SougouInput input = new SougouInput();
        // 2.创建默认皮肤类对象
        DefaultSkin skin = new DefaultSkin();
        // 3.将皮肤设置到输入法中
        input.setSkin(skin);
        // 4.显示皮肤
        input.display();
    }
}
