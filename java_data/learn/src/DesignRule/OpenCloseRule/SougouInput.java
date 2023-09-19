package DesignRule.OpenCloseRule;

// 搜狗输入类，设置并显示皮肤
public class SougouInput {  // 此类聚合于 AbstractSkin，等 AbstractSkin 传递一个参数给它
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display() {
        skin.display();
    }
}
