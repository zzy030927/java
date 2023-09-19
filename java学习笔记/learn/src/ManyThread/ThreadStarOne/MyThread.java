package ManyThread.ThreadStarOne;

// 1. 继承 Thread 类
public class MyThread extends Thread{

    @Override
    public void run(){
        // 书写重写的代码
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() +"启用" + (i+1));
            Thread.yield(); // 当前先当礼让其他线程，交出CPU控制权
        }
    }
}
