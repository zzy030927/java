package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode3;

public class Test {
    public static void main(String[] args) {
        Slob instance = Slob.getInstance();
        Slob instance1 = Slob.getInstance();
        System.out.println(instance == instance1);  // true
    }
}
