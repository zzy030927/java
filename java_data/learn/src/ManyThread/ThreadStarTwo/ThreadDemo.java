package ManyThread.ThreadStarTwo;

// 多线程第二种启动方式
// 1.自定义一个类 实现 Runnable 类
// 2.重写里面的 run() 方面
// 3.创建自己类的对象
// 4.创建一个Thread类的对象，并开启线程
public class ThreadDemo {
    public static void main(String[] args) {
        // 3. 创建 MyRun 的对象
        // 表示多线程要执行的任务
        MyRun myRun = new MyRun();

        // 4.创建线程对象
        Thread thread1 = new Thread(myRun);  // 把要做的任务传递给线程
        Thread thread2 = new Thread(myRun);  // 把要做的任务传递给线程
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start(); // 开启线程
        thread2.start(); // 开启线程
    }
}
