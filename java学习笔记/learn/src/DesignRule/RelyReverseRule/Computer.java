package DesignRule.RelyReverseRule;

// ������࣬�� HardDisk,CPU,Memory ��Ͻ���
public class Computer {
    private HardDisk hardDisk;
    private Cpu cpu;
    private Memory memory;

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void run(){
        System.out.println("���м����");
        String data = hardDisk.get(); // ��Ӳ���ϻ�ȡ����
        System.out.println(data);
        cpu.run();  // cpu����
        memory.save();  // �ڴ����洢
    }
}
