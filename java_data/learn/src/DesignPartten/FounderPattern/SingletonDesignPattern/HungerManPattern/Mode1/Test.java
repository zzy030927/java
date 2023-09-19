package DesignPartten.FounderPattern.SingletonDesignPattern.HungerManPattern.Mode1;

// 测试类
public class Test {
    public static void main(String[] args) {
        // 创建 Singleton 类的对象
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        // 判断获取到的两个对象是否是同一个对象
        System.out.println(instance == instance1);  // true,
                                                    // 说明 Singleton 这个类只能创建一个对象
                                                    // 这就是单例设计模式
    }
}
