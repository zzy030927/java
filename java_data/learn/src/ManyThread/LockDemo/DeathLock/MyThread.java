package ManyThread.LockDemo.DeathLock;


public class MyThread extends Thread {

    static Object a = new Object();
    static Object b = new Object();

    @Override
    public void run() {
        while (true) {
            if ("�߳�A".equals(getName())) {
                synchronized (a) {
                    System.out.println("�߳�A�õ���A����׼����B��");   // A���е������õ��� A�����ر� A����
                                                                    // ͬʱ�� B��ռ��ִ��Ȩ
                    synchronized (b) {
                        System.out.println("�߳�A�õ���B����ִ�����");
                    }
                }
            } else if ("�߳�B".equals(getName())) {   // B��������
                if ("�߳�B".equals(getName())) {
                    synchronized (b) {  // B�õ��� B����ͬʱ�ر� B ����
                                        // ���Ǿ������˽��֣� A �� B��ͬʱ�رգ���˭Ҳ�ͷŲ�������
                        System.out.println("�߳�B�õ���B����׼����A��");
                        synchronized (a) {
                            System.out.println("�߳�B�õ���A����ִ�����");
                        }
                    }
                }
            }
        }
    }
}
