package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode1;

public class Test {
    public static void main(String[] args) {
        Slob instance = Slob.getInstance(); // ����ʽֻ���ڴ������ø÷���ʱ�Żᴴ���ö��󣬷�����������һֱ�� null
        Slob instance1 = Slob.getInstance();
        System.out.println(instance1 == instance);  // true
    }
}
