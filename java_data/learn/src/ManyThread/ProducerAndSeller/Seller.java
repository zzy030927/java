package ManyThread.ProducerAndSeller;

// 消费者
public class Seller extends Thread {
    @Override
    public void run() {
        while(true){
            synchronized (Platform.lock){
                if(Platform.count == 0){
                    break;
                }else {
                    // 先判断 Platform（平台上） 是否有食物
                    if(Platform.foodFlag == 0) {
                        // 平台上没有食物就去让 唤醒 Producer 制造食物
                        try {
                            Platform.lock.wait();   // 调用锁的 wait() 方法， 让当前线程和锁进行绑定，让当前线程去等待。
                                                    // 这是线程被 Producer 抢占
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("在吃第" + Platform.count + "个食物");
                        Platform.count--;   // 食物总数 -1
                        // 吃完之后，唤醒 Produce 继续制造食物
                        Platform.lock.notifyAll(); // 之所以当前线程要和锁进行绑定，就是说唤醒该线程时知道唤醒的是哪条线程。
                                                   // 如果直接调用 notify()方法， 会唤醒所有的线程。
                                                   // 这里是唤醒生产者去做食物

                        Platform.foodFlag = 0;     // 现在平台上没有食物
                    }
                }
            }
        }
    }
}
