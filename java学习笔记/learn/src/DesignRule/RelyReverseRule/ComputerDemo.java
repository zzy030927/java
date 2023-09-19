package DesignRule.RelyReverseRule;

public class ComputerDemo {
    public static void main(String[] args) {
        // 计算机对象
        Computer computer = new Computer();
        // 计算机组件对象
        HardDisk xiJieHardDisk = new XiJieHardDisk();
        Cpu interCPU = new InterCPU();
        Memory kingstonMemory = new KingstonMemory();
        // 组装计算机
        computer.setHardDisk(xiJieHardDisk);
        computer.setCpu(interCPU);
        computer.setMemory(kingstonMemory);
        // 运行
        computer.run();
    }
}
