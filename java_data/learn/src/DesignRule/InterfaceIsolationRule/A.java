package DesignRule.InterfaceIsolation;

public class A implements AntiTheft, Fireproof, Waterproof{
    @Override
    public void antiTheft() {
        System.out.println("����");
    }

    @Override
    public void fireproof() {
        System.out.println("����");
    }

    @Override
    public void waterproof() {
        System.out.println("����");
    }
}
