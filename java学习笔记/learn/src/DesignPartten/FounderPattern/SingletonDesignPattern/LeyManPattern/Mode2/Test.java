package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode2;

public class Test {
    public static void main(String[] args) {
        Slob instance = Slob.getInstance();
        Slob instance1 = Slob.getInstance();
        System.out.println(instance1 == instance);  // true
    }
}
