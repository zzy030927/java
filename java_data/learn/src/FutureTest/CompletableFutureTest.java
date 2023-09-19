package FutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// CompletableFuture���ṩ�˺�����̵�����������ͨ���ص��ķ�ʽ���������������֧����ϲ���
// �ṩ�ܶ෽����ʵ���첽���ţ������첽��̵ĸ��Ӷȡ�

// CompletableFutureʵ�� Future �� CompletionStage �����ӿڣ�
// Future����ʾ�첽����Ľ����
// CompletionStage����ʾ�첽�����һ�����裬��һ���׶μ������ʱ�����ܻᴥ�������׶Σ���������������� CompletionStage ����
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        // �̳߳�
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // ����ִ��
        CompletableFuture<String> cft = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "call() run()";
        }, executor);
        System.out.println("Main run()");
        // ������
        System.out.println(cft.get());
    }
}

