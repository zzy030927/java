package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode1;

// 单例设计模式 - 懒汉式 - 实现方式一（该方式线程不安全）
public class Slob {
    // 私有构造方法
    private Slob() {}

    // 声明该类静态变量
    private static Slob instance = null;

    // 对外提供访问方式
    public static synchronized Slob getInstance(){
        if(instance == null)    // 如果 instance 还没有创建，那么创建该对象，否则就不创建
            // 此处线程是不安全的，因为 如果此处为多线程，
            // 线程一和线程二同时调用该方法，线程一进入该方法时进行判断后时间片用完进行等待
            // 线程二获取cpu控制权，同时线程一还没有创建对象，那么线程二也进入该方法进行判断等待创建对象，
            // 线程二时间片用完，线程一创建对象
            // 因为线程二已经判断完毕，所以线程二也创建了一个对象
            instance = new Slob();
        return instance;
    }
}
