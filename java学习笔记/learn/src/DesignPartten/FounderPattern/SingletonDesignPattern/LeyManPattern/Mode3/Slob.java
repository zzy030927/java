package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode3;

import java.io.Serializable;

// �������ģʽ - ����ʽ - ��Ʒ�ʽ���� ��̬�ڲ��෽ʽ
/*
    ��̬�ڲ��൥�����ģʽ��ʵ�����ڲ��ഴ�������� JVM �ڼ����ⲿ��Ĺ����У��ǲ�����ؾ�̬�ڲ���ģ�ֻ�о�̬�ڲ�������ԡ�����������ʱ
    �Żᱻ���أ�����ʼ���侲̬���ԣ���̬������ static ���Σ���ֻ֤��ʵ����һ�Σ������ϸ�֤ʵ����˳��
 */
public class Slob implements Serializable { // ʵ�����л��Ľӿ�

    private static boolean flag = false;

    // ˽�й��췽��
    private Slob() {
        synchronized (Slob.class) {
            // �ж� flag ��ֵ�Ƿ��� true, ����� true, ��ô��˵���Ƿǵ�һ�η���,ֱ����һ���쳣
            // ������ǵ�һ�η���
            if (flag) {
                throw new RuntimeException("���ܴ����������");
            }
            // ��һ�η��ʣ��� flag ��ֵ����Ϊ ture֮��, ȥ�����ڲ���ȥ��������
            flag = true;
        }
    }

    // ����һ����̬�ڲ���, SlobHolder �� Slob������
    private static class SlobHolder{
        // ���ڲ�������������ʼ���ⲿ��Ķ���
        private static final Slob INSTANCE = new Slob();    // �� final ���εı���ֻ�ܱ���ֵһ�Σ��൱�ڳ���
    }

    // �ṩ�����ķ��ʷ�ʽ
    public static Slob getInstance(){
        return SlobHolder.INSTANCE;
    }

    // �����з����л�ʱ�����Զ����ø÷��������÷����ķ���ֱֵ�ӷ��ء�
    public Object readResolve(){
        return SlobHolder.INSTANCE;
    }
}
