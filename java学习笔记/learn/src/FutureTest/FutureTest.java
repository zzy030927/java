package FutureTest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// �첽�Ƕ����̵Ľ�������е��������������첽ִ�е����ս������ô��Ҫʹ�� Future�ӿڡ�
// FutureTask���� Future�ӿڵĻ���ʵ���࣬�ṩ�˼����������ȡ������ѯ�����Ƿ�����Լ������������ķ���
// �ڡ�FutureTask�����У����Կ����߳��첽ִ������ʱ�����еĺ���״̬ת�����Լ����ս��д���ķ�ʽ
// FutureTask��ʵ���� RunnableFuture �ӿڣ� RunnableFuture�ӿڼ̳��� Runnable�ӿں� Future �ӿ�
class ServerTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 3;
    }
}

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        // �̳߳�
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // ��������
        ArrayList<ServerTask> serverTasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            serverTasks.add(new ServerTask());
        }
        // �ύ����
        List<Future<Integer>> futures = executorService.invokeAll(serverTasks);
        for (Future<Integer> future : futures) {
            System.out.println(future.get());   // �ȴ�������ɣ���ȡִ�н��
        }
        // ͳ��ʱ�䣬���к�ʱ 2s�࣬���л���ʱ 6s
        long endTime = System.currentTimeMillis();
        System.out.println("time = " + (endTime - startTime));
        System.out.println(futures.get(0).isDone());    // �Ƿ����
        System.out.println(futures.get(0).cancel(true));    // ȡ������ִ�У�����ȡ���Ľ�� ��������ɺ�ȡ��ʧ�ܣ�
        System.out.println(futures.get(0).isCancelled());   // �Ƿ�ȡ��
// ��Ȼ��Future��������ϣ�ʵ�����첽����Ľ����ȡ������ͨ������İ���Ҳ���Է��֣�
// ���̵����߳���ִ��get()����ʱ��������ֱ�����ջ�ȡ�������Ȼ���ڳ�����˵�����Ѻã�
// ��JDK1.8�ṩ��CompletableFuture���࣬�ԡ�Future�������Ż�����չ��
    }
}
