package DesignPartten.FounderPattern.SingletonDesignPattern.HungerManPattern.Mode1;

// ������
public class Test {
    public static void main(String[] args) {
        // ���� Singleton ��Ķ���
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        // �жϻ�ȡ�������������Ƿ���ͬһ������
        System.out.println(instance == instance1);  // true,
                                                    // ˵�� Singleton �����ֻ�ܴ���һ������
                                                    // ����ǵ������ģʽ
    }
}
