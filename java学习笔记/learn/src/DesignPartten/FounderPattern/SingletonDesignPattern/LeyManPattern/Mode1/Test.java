package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode1;

public class Test {
    public static void main(String[] args) {
        Slob instance = Slob.getInstance(); // 懒汉式只有在创建调用该方法时才会创建该对象，否则该类的引用一直是 null
        Slob instance1 = Slob.getInstance();
        System.out.println(instance1 == instance);  // true
    }
}
