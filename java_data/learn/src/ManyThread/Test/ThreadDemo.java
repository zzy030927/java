package ManyThread.Test;

public class ThreadDemo {
    public static void main(String[] args) {
        // ���������̻߳�ȡż��
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setName("�߳�1");
        myThread2.setName("�߳�2");
        myThread1.setPriority(1);
        myThread2.setPriority(10);
        myThread1.start();
        myThread2.start();

    }
}
