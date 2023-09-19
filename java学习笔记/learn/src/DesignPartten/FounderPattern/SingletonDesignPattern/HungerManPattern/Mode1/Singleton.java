package DesignPartten.FounderPattern.SingletonDesignPattern.HungerManPattern.Mode1;

import java.security.Signature;

// �������ģʽ - ����ʽ - ʵ�ַ�ʽһ����̬��Ա������ʽ
public class Singleton {

    // 1. ˽�й��췽����������紴������
    private Singleton() {}

    // 2. �ڱ����д�������Ķ���
    private static Singleton instance = new Singleton();

    // 3. �ṩһ�������ķ��ʷ�ʽ������ȡ�ö���
    // ��Ϊ����޷���������Ķ������Դ˷���Ҫ����Ϊ��̬�ķ���
    public static Singleton getInstance(){
        // ��̬�����޷���ȡ�Ǿ�̬���������� instance Ҫ����Ϊ��̬��
        return instance;
    }

}
