package ManyThread.LockDemo.DeathLock;

// 死锁：这是一个错误，不要犯该错误
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setName("线程A");
        myThread2.setName("线程B");

        myThread1.start();
        myThread2.start();
    }
}
