package ManyThread.MethodOfDaemonThread;

// ���̳߳��÷���֮ �ػ��߳�
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.setName("Ů��");
        myThread2.setName("��̥");

        myThread2.setDaemon(true);  // ��̥�߳�
                                    // ���������ػ��߳�ִ�����ʱ�����ػ��߳�Ҳ��½��ִ����ϡ�
                                    // �ػ��߳��ڷ��ػ��߳�ִ����Ϻ�û��ִ������ɵı�Ҫ�ˡ�

        myThread1.start();
        myThread2.start();
    }
}
