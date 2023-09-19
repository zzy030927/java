package ManyThread.ProducerAndSeller.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

// 用 阻塞队列方式实现生产者与消费者问题
public class ThreadDemo {
    public static void main(String[] args) {
        // 生产者和消费者必须放在一个阻塞队列中

        // 阻塞队列
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<>(1);    // 数组形式的阻塞队列，1 为容量

        // 创建线程
        Producer producer = new Producer(arrayBlockingQueue);
        Seller seller = new Seller(arrayBlockingQueue);

        producer.start();
        seller.start();
    }
}
