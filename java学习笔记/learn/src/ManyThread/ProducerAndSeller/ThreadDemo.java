package ManyThread.ProducerAndSeller;

public class ThreadDemo {
    public static void main(String[] args) {
        // 需求：完成生产和和消费者（等待唤醒机制）的代码
        // 实现线程的轮流交替的效果


        // 创建线程对象
        Producer producer = new Producer();
        Seller seller = new Seller();

        producer.setName("生产者");
        seller.setName("消费者");

        producer.start();
        seller.start();
    }
}
