package ManyThread.ThradPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// 线程池 和 数据库连接池相同
public class MyThreadPool {
    public static void main(String[] args) {
        // public static Executors newCachedThreadPool() 创建一个没有上限的线程池
        // public static Executors.newFixedThreadPool(int nThreads); 创建一个有上线的线程池

        // 1.获取线程池对象
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 创建任务对象
        MyRunnable runnable1 = new MyRunnable();
        MyRunnable runnable2 = new MyRunnable();

        // 2.提交任务
        executorService.submit(runnable1);
        executorService.submit(runnable2);


        // 3. 销毁线程池 - 线程池一般不会销毁
        // executorService.shutdown();
    }
}
