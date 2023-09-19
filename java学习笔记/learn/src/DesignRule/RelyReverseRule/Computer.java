package DesignRule.RelyReverseRule;

// 计算机类，将 HardDisk,CPU,Memory 组合进来
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
        System.out.println("运行计算机");
        String data = hardDisk.get(); // 从硬盘上获取数据
        System.out.println(data);
        cpu.run();  // cpu运行
        memory.save();  // 内存条存储
    }
}
