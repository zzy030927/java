package DesignPartten.FounderPattern.SingletonDesignPattern.HungerManPattern.Mode2;

// ����ʵ��ģʽ - ����ʽ - ʵ�ַ�ʽ������̬����鷽ʽ
public class Singleton {
    // ˽�й��췽��
    private Singleton() {}

    // ���� Singleton ���͵ı���
    private static Singleton instance = null;

    // �ھ�̬������н��и�ֵ
    static{
        instance = new Singleton();
    }

    // �����ṩ��ȡ�������ķ���
    public static Singleton getInstance(){
        return instance;
    }
}
