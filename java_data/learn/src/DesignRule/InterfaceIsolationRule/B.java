package DesignRule.InterfaceIsolation;

public class B implements AntiTheft, Fireproof{
    @Override
    public void antiTheft() {
        System.out.println("����");
    }

    @Override
    public void fireproof() {
        System.out.println("����");
    }
}
