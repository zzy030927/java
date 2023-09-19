package ManyThread.ThreadSafetyProblem;

// 线程安全问题
public class ThreadDemo {
    // 题目：三个窗口卖 100 张票
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        myThread1.setName("窗口1");
        myThread2.setName("窗口2");
        myThread3.setName("窗口3");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
