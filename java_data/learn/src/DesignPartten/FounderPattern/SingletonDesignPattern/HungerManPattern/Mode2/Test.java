package DesignPartten.FounderPattern.SingletonDesignPattern.HungerManPattern.Mode2;

public class Test {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        System.out.println(instance == instance1);
    }
}
