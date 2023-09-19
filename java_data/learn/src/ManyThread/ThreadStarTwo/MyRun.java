package ManyThread.ThreadStarTwo;

// 1.自定义一个类去实现 Runnable 接口
public class MyRun implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread thread = Thread.currentThread(); // 静态方法获取当前的线程对象
            // 细节： 在 JVM 虚拟机启动后，会自动的启动多条线程
            // 其中一条线程就叫 main 线程
            // 它的作用是去调用 main 方法，并执行里面的代码。
            System.out.println(thread.getName() +","+ (i+1));
        }
    }
}
