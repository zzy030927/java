package ManyThread.ThreadStarTwo;

// 1.�Զ���һ����ȥʵ�� Runnable �ӿ�
public class MyRun implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Thread thread = Thread.currentThread(); // ��̬������ȡ��ǰ���̶߳���
            // ϸ�ڣ� �� JVM ����������󣬻��Զ������������߳�
            // ����һ���߳̾ͽ� main �߳�
            // ����������ȥ���� main ��������ִ������Ĵ��롣
            System.out.println(thread.getName() +","+ (i+1));
        }
    }
}
