package DesignRule.OpenCloseRule;

// 默认皮肤类，重写 AbstractSkin 类中的方法
public class DefaultSkin extends AbstractSkin
{
    @Override
    public void display() {
        System.out.println("默认皮肤");
    }
}
