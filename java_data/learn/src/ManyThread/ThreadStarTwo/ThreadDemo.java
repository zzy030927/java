package ManyThread.ThreadStarTwo;

// ���̵߳ڶ���������ʽ
// 1.�Զ���һ���� ʵ�� Runnable ��
// 2.��д����� run() ����
// 3.�����Լ���Ķ���
// 4.����һ��Thread��Ķ��󣬲������߳�
public class ThreadDemo {
    public static void main(String[] args) {
        // 3. ���� MyRun �Ķ���
        // ��ʾ���߳�Ҫִ�е�����
        MyRun myRun = new MyRun();

        // 4.�����̶߳���
        Thread thread1 = new Thread(myRun);  // ��Ҫ�������񴫵ݸ��߳�
        Thread thread2 = new Thread(myRun);  // ��Ҫ�������񴫵ݸ��߳�
        thread1.setName("�߳�1");
        thread2.setName("�߳�2");
        thread1.start(); // �����߳�
        thread2.start(); // �����߳�
    }
}
