package ManyThread.Test3;

import java.util.ArrayList;
import java.util.Collections;

// 抽奖箱抽奖
/*
    有一个抽奖箱，该抽奖池中存放了奖励的金额，该抽奖箱的奖项为 {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700}
    创建两个抽奖箱
    随机的从抽奖池中获取奖项元素并打印在控制台上，格式如下：
        每次抽出一个奖项就打印一遍
 */
public class ThreadDemo {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        // Collections中的静态方法 addAll 将所有参数添加到 list 中
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);

        MyThread myThread1 = new MyThread(list);
        MyThread myThread2 = new MyThread(list);
        MyThread myThread3 = new MyThread(list);
        MyThread myThread4 = new MyThread(list);
        MyThread myThread5 = new MyThread(list);

        myThread1.setName("线程1");
        myThread2.setName("线程2");
        myThread3.setName("线程2");
        myThread4.setName("线程4");
        myThread5.setName("线程5");

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
    }
}
