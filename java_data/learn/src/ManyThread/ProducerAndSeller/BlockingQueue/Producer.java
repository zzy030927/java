package ManyThread.ProducerAndSeller.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Producer extends Thread{

    ArrayBlockingQueue queue;

    public Producer(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // 不断地把面条放到阻塞队列中
        while(true){
            try {
                queue.put("面条");    // put 方法里面有锁，
                System.out.println("厨师放了一碗面条"); // sout 语句在锁的外面
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
