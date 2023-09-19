package DesignPartten.FounderPattern.SingletonDesignPattern.HungerManPattern.Mode1;

import java.security.Signature;

// 单例设计模式 - 饿汉式 - 实现方式一：静态成员变量方式
public class Singleton {

    // 1. 私有构造方法：不让外界创建对象
    private Singleton() {}

    // 2. 在本类中创建本类的对象
    private static Singleton instance = new Singleton();

    // 3. 提供一个公共的访问方式让外界获取该对象
    // 因为外界无法创建该类的对象，所以此方法要声明为静态的方法
    public static Singleton getInstance(){
        // 静态方法无法获取非静态变量，所以 instance 要声明为静态的
        return instance;
    }

}
