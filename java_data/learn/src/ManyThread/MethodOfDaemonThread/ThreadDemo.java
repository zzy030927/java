package ManyThread.MethodOfDaemonThread;

// 多线程常用方法之 守护线程
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.setName("女神");
        myThread2.setName("备胎");

        myThread2.setDaemon(true);  // 备胎线程
                                    // 当其他非守护线程执行完毕时，非守护线程也会陆续执行完毕。
                                    // 守护线程在非守护线程执行完毕后没有执行完完成的必要了。

        myThread1.start();
        myThread2.start();
    }
}
