package ManyThread.ThreadStarThree;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// 多线程启动方式三： 特点： 可以获取到多线程运行的结果
// 1. 创建一个类去实现 Callable 接口
// 2. 重写call (是有返回值的，表示多线程运行的结果)
// 3. 创建 MyCallable 的对象，表示多线程要执行的任务
// 4. 创建 Future 对象，用来管理多线程运行的结果, 因为 Future 是一个接口，所以要创建 Future 的实现类 FutureTask的对象
// 5. 创建 Thread 的对象
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 3. 多线程要执行的任务
        MyCallable myCallable = new MyCallable();
        // 4. 把任务放入参数中，用这个对象管理运行的结果
        FutureTask<Integer> task = new FutureTask<>(myCallable);
        // 5. 创建线程
        Thread thread = new Thread(task);
        thread.start();

        // 6. 获取多线程运行的结果
        Integer integer = task.get();
        System.out.println(integer);
    }
}
