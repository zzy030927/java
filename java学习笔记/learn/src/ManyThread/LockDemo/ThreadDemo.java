package ManyThread.LockDemo;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        myThread1.setName("����1");
        myThread2.setName("����2");
        myThread3.setName("����3");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
