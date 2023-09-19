package ManyThread.LockDemo.DeathLock;


public class MyThread extends Thread {

    static Object a = new Object();
    static Object b = new Object();

    @Override
    public void run() {
        while (true) {
            if ("线程A".equals(getName())) {
                synchronized (a) {
                    System.out.println("线程A拿到了A锁，准备拿B锁");   // A运行到这里拿到了 A锁，关闭 A锁，
                                                                    // 同时被 B抢占了执行权
                    synchronized (b) {
                        System.out.println("线程A拿到了B锁，执行完毕");
                    }
                }
            } else if ("线程B".equals(getName())) {   // B运行这里
                if ("线程B".equals(getName())) {
                    synchronized (b) {  // B拿到了 B锁，同时关闭 B 锁，
                                        // 这是就陷入了僵局， A 锁 B锁同时关闭，又谁也释放不了锁。
                        System.out.println("线程B拿到了B锁，准备拿A锁");
                        synchronized (a) {
                            System.out.println("线程B拿到了A锁，执行完毕");
                        }
                    }
                }
            }
        }
    }
}
