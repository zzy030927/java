package ManyThread.ThreadStarOne;


public class ThreadDemo {
    // ���߳�������ʽ
    // 1. �̳� Thread ��
    // 2. �����������
    // 3. �������߳�
    public static void main(String[] args) {
        // 2. �����������
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.setName("�߳�1");   // ���߳�������
        myThread2.setName("�߳�2");

        System.out.println(myThread1.getPriority());    // ���ȼ�Ĭ��Ϊ 5
        myThread1.setPriority(2);
        myThread2.setPriority(1);

        // 3.�������߳�
        myThread1.start();   // �����߳�
        myThread2.start();   // �����߳�

    }
}
