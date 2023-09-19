package FutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// CompletableFuture类提供了函数编程的能力，可以通过回调的方式处理计算结果，并且支持组合操作
// 提供很多方法来实现异步编排，降低异步编程的复杂度。

// CompletableFuture实现 Future 和 CompletionStage 两个接口；
// Future：表示异步计算的结果；
// CompletionStage：表示异步计算的一个步骤，当一个阶段计算完成时，可能会触发其他阶段，即步骤可能由其他 CompletionStage 触发
public class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        // 线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 任务执行
        CompletableFuture<String> cft = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "call() run()";
        }, executor);
        System.out.println("Main run()");
        // 结果输出
        System.out.println(cft.get());
    }
}

