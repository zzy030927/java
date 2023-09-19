package ManyThread.Test;

public class ThreadDemo {
    public static void main(String[] args) {
        // 案例：多线程获取偶数
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setName("线程1");
        myThread2.setName("线程2");
        myThread1.setPriority(1);
        myThread2.setPriority(10);
        myThread1.start();
        myThread2.start();

    }
}
