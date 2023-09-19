package ManyThread.ProducerAndSeller;

// 生产者
public class Producer extends Thread {
    @Override
    public void run() {
        while(true){
            synchronized (Platform.lock){
                if(Platform.count == 0){
                    break;
                }else {
                    if (Platform.foodFlag == 1) {    // 判断平台上是否有食物
                        try {
                            Platform.lock.wait();   // 有食物就等待消费者吃食物
                                                    // 线程被 Seller 抢占
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("厨师做了一碗面条");
                        Platform.foodFlag = 1;
                        // 唤醒等待的消费者吃食物
                        Platform.lock.notifyAll();
                    }
                }
            }
        }
    }
}
