package DesignRule.OpenCloseRule;

// �ѹ������࣬���ò���ʾƤ��
public class SougouInput {  // ����ۺ��� AbstractSkin���� AbstractSkin ����һ����������
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display() {
        skin.display();
    }
}
