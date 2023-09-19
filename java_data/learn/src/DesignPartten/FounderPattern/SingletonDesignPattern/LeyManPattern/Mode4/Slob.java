package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode4;

// 单例设计模式 - 懒汉式 - 设计方式四：枚举方式
/*
    枚举类实现单例模式是极力推荐的单例实现模式，因为枚举类型是线程安全的，并且
    只会加载一次，设计者充分的利用了枚举这个特性来实现单例模式，枚举的写法非常简单，而且
    枚举类型是所有单例模型中 唯一一种不会被破坏的单例模型。
 */
public enum Slob {
    INSTANCE;
}
