package ManyThread.LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 锁：相比于 synchronized 同步代码块而言，Lock 这个类中提供了手动上锁和手动释放锁的函数
// 因为 Lock 是一个接口，所以我们要继承 实现Lock的类： ReentrantLock类
public class MyThread extends Thread {

    static int ticket = 0;
    static Lock lock = new ReentrantLock(); // 由于是多线程，可能会有多个对象 new MyThread()，所以要把 lock 声明为静态的，防止有多个锁出现。

    @Override
    public void run() {
        while(true){
            lock.lock();    // 上锁
            if(ticket < 100){
                ticket++;
                System.out.println(getName() + "正在第卖" + ticket + "张票!");
            }
            else {
                lock.unlock();  // 跳出循环的同时关闭锁对象
                break;
            }
            lock.unlock();  // 释放锁
        }
    }
}
