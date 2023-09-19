package ManyThread.ProducerAndSeller.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Seller extends Thread{

    ArrayBlockingQueue queue;

    public Seller(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                Object food = queue.take();
                System.out.println("Ётак" + food);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
