package DesignRule.OpenCloseRule;

public class Client // Client �ͻ���
{
    public static void main(String[] args) {
        // 1.�����ѹ����������
        SougouInput input = new SougouInput();
        // 2.����Ĭ��Ƥ�������
        DefaultSkin skin = new DefaultSkin();
        // 3.��Ƥ�����õ����뷨��
        input.setSkin(skin);
        // 4.��ʾƤ��
        input.display();
    }
}
