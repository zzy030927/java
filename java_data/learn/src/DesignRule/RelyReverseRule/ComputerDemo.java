package DesignRule.RelyReverseRule;

public class ComputerDemo {
    public static void main(String[] args) {
        // ���������
        Computer computer = new Computer();
        // ������������
        HardDisk xiJieHardDisk = new XiJieHardDisk();
        Cpu interCPU = new InterCPU();
        Memory kingstonMemory = new KingstonMemory();
        // ��װ�����
        computer.setHardDisk(xiJieHardDisk);
        computer.setCpu(interCPU);
        computer.setMemory(kingstonMemory);
        // ����
        computer.run();
    }
}
