package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode3;

import java.io.Serializable;

// 单例设计模式 - 懒汉式 - 设计方式三： 静态内部类方式
/*
    静态内部类单例设计模式中实例由内部类创建，由于 JVM 在加载外部类的过程中，是不会加载静态内部类的，只有静态内部类的属性、方法被调用时
    才会被加载，并初始化其静态属性，静态属性由 static 修饰，保证只被实例化一次，并且严格保证实例化顺序。
 */
public class Slob implements Serializable { // 实现序列化的接口

    private static boolean flag = false;

    // 私有构造方法
    private Slob() {
        synchronized (Slob.class) {
            // 判断 flag 的值是否是 true, 如果是 true, 那么就说明是非第一次访问,直接抛一个异常
            // 否则就是第一次访问
            if (flag) {
                throw new RuntimeException("不能创建多个对象");
            }
            // 第一次访问，将 flag 的值设置为 ture之后, 去创建内部类去创建对象
            flag = true;
        }
    }

    // 定义一个静态内部类, SlobHolder ： Slob持有人
    private static class SlobHolder{
        // 在内部类中声明并初始化外部类的对象
        private static final Slob INSTANCE = new Slob();    // 被 final 修饰的变量只能被赋值一次，相当于常量
    }

    // 提供公共的访问方式
    public static Slob getInstance(){
        return SlobHolder.INSTANCE;
    }

    // 当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回。
    public Object readResolve(){
        return SlobHolder.INSTANCE;
    }
}
