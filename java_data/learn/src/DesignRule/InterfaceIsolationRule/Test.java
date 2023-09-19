package DesignRule.InterfaceIsolation;

public class Test {
    public static void main(String[] args) {
        System.out.println("-----A----");
        A a = new A();
        a.antiTheft();
        a.fireproof();
        a.waterproof();
        System.out.println("-----B----");
        B b = new B();
        b.antiTheft();
        b.fireproof();
    }
}
