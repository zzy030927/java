package DesignPartten.FounderPattern.SingletonDesignPattern.HungerManPattern.Mode2;

// 单例实现模式 - 饿汉式 - 实现方式二：静态代码块方式
public class Singleton {
    // 私有构造方法
    private Singleton() {}

    // 声明 Singleton 类型的变量
    private static Singleton instance = null;

    // 在静态代码块中进行赋值
    static{
        instance = new Singleton();
    }

    // 对外提供获取该类对象的方法
    public static Singleton getInstance(){
        return instance;
    }
}
