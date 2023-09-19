package FutureTest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// 异步是对流程的解耦，但是有的流程又依赖于异步执行的最终结果，那么就要使用 Future接口。
// FutureTask类是 Future接口的基本实现类，提供了计算的启动和取消，查询计算是否完成以及检索计算结果的方法
// 在「FutureTask」类中，可以看到线程异步执行任务时，其中的核心状态转换，以及最终结果写出的方式
// FutureTask类实现了 RunnableFuture 接口， RunnableFuture接口继承了 Runnable接口和 Future 接口
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
        // 线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 批量任务
        ArrayList<ServerTask> serverTasks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            serverTasks.add(new ServerTask());
        }
        // 提交任务
        List<Future<Integer>> futures = executorService.invokeAll(serverTasks);
        for (Future<Integer> future : futures) {
            System.out.println(future.get());   // 等待任务完成，获取执行结果
        }
        // 统计时间，并行耗时 2s多，串行化耗时 6s
        long endTime = System.currentTimeMillis();
        System.out.println("time = " + (endTime - startTime));
        System.out.println(futures.get(0).isDone());    // 是否完成
        System.out.println(futures.get(0).cancel(true));    // 取消任务执行，返回取消的结果 （任务完成后取消失败）
        System.out.println(futures.get(0).isCancelled());   // 是否被取消
// 虽然「Future」从设计上，实现了异步计算的结果获取，但是通过上面的案例也可以发现，
// 流程的主线程在执行get()方法时会阻塞，直到最终获取结果，显然对于程序来说并不友好；
// 在JDK1.8提供「CompletableFuture」类，对「Future」进行优化和扩展；
    }
}
