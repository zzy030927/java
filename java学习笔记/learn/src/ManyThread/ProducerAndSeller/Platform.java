package ManyThread.ProducerAndSeller;

// 控制生产者和消费者的交替执行
public class Platform { // platform ： 平台
    public static int foodFlag = 0;  // 1 表示有食物，0 表示没有食物

    // 食物总个数
    public static int count = 10;

    // 锁对象
    public static Object lock = new Object();
}
