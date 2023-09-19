package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode3;
import java.lang.reflect.Constructor;

public class ReflectBreak {
    public static void main(String[] args) throws Exception{
        Class<Slob> clazz = Slob.class;

        // 2.��ȡ�޲ι��췽������
        Constructor<Slob> cons = clazz.getDeclaredConstructor();

        // 3.ȡ�����ʼ�� ���������䣩
        cons.setAccessible(true);

        // 4.ͨ�����䴴�� Slob ����
        Slob slob1 = cons.newInstance();
//        Slob slob2 = cons.newInstance();  �������ܴ����������
    }
}
