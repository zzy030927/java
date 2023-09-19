package ManyThread.ThradPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// �̳߳� �� ���ݿ����ӳ���ͬ
public class MyThreadPool {
    public static void main(String[] args) {
        // public static Executors newCachedThreadPool() ����һ��û�����޵��̳߳�
        // public static Executors.newFixedThreadPool(int nThreads); ����һ�������ߵ��̳߳�

        // 1.��ȡ�̳߳ض���
        ExecutorService executorService = Executors.newCachedThreadPool();

        // �����������
        MyRunnable runnable1 = new MyRunnable();
        MyRunnable runnable2 = new MyRunnable();

        // 2.�ύ����
        executorService.submit(runnable1);
        executorService.submit(runnable2);


        // 3. �����̳߳� - �̳߳�һ�㲻������
        // executorService.shutdown();
    }
}
