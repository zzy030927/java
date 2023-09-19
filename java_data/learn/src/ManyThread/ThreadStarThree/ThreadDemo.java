package ManyThread.ThreadStarThree;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// ���߳�������ʽ���� �ص㣺 ���Ի�ȡ�����߳����еĽ��
// 1. ����һ����ȥʵ�� Callable �ӿ�
// 2. ��дcall (���з���ֵ�ģ���ʾ���߳����еĽ��)
// 3. ���� MyCallable �Ķ��󣬱�ʾ���߳�Ҫִ�е�����
// 4. ���� Future ��������������߳����еĽ��, ��Ϊ Future ��һ���ӿڣ�����Ҫ���� Future ��ʵ���� FutureTask�Ķ���
// 5. ���� Thread �Ķ���
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 3. ���߳�Ҫִ�е�����
        MyCallable myCallable = new MyCallable();
        // 4. �������������У����������������еĽ��
        FutureTask<Integer> task = new FutureTask<>(myCallable);
        // 5. �����߳�
        Thread thread = new Thread(task);
        thread.start();

        // 6. ��ȡ���߳����еĽ��
        Integer integer = task.get();
        System.out.println(integer);
    }
}
