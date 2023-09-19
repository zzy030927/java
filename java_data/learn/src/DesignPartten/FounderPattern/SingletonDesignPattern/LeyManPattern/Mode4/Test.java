package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode4;

public class Test {
    public static void main(String[] args) {
        Slob instance = Slob.INSTANCE;
        Slob instance1 = Slob.INSTANCE;
        System.out.println(instance == instance1);  // true
    }
}
