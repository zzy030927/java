package ManyThread.LockDemo.DeathLock;

// ����������һ�����󣬲�Ҫ���ô���
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setName("�߳�A");
        myThread2.setName("�߳�B");

        myThread1.start();
        myThread2.start();
    }
}
