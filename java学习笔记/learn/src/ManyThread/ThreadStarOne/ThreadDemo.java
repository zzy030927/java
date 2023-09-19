package ManyThread.ThreadStarOne;


public class ThreadDemo {
    // 多线程启动方式
    // 1. 继承 Thread 类
    // 2. 创建子类对象
    // 3. 启动该线程
    public static void main(String[] args) {
        // 2. 创建子类对象
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setName("线程1");   // 给线程起名字
        myThread2.setName("线程2");

        System.out.println(myThread1.getPriority());    // 优先级默认为 5
        myThread1.setPriority(2);
        myThread2.setPriority(1);

        // 3.启动该线程
        myThread1.start();   // 开启线程
        myThread2.start();   // 开启线程

    }
}
