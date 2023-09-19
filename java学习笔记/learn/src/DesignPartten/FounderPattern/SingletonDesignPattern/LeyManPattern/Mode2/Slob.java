package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode2;

// 单例设计模式 - 懒汉式 - 实现方式二：双重检查锁
public class Slob {
    private Slob() {}

    // 声明类型的变量
    private static volatile Slob instance = null;

    // 对外提供公共的访问方式
    public static  Slob getInstance(){
        // 第一次判断： 如果 instance 的值不为 null, 那么不需要抢占锁，直接返回对象
        if(instance == null){
            // 同步代码块，参数为 锁对象，即当前类的字节码对象
            synchronized (Slob.class){
                // 避免被其他对象先抢占创建对象，再判断一次
                if(instance == null){
                    instance = new Slob();
                }
            }
        }
        return instance;
    }
}
