package ManyThread.Test2;

import java.util.Random;

public class MyThread extends Thread {
    // 共享数据
    static double money = 100;  // 红包金额
    static int count = 3;       // 红包个数

    // 最少金额
    static final double MIN_MONEY = 0.01;

    @Override
    public void run() {
        synchronized (MyThread.class) {
            if (count == 0) {
                System.out.println(getName() + "没有抢到红包");
            } else {
                double prize;   // 随机到的金额
                if (count == 1) {
                    // 无需随机，剩下的都是中奖金额
                    prize = money;
                } else {
                    // 第一次、第二次抢红包，随机金额
                    Random random = new Random();
                    prize = random.nextDouble(money - (count - 1) * MIN_MONEY);
                    if(prize < MIN_MONEY)
                        prize = MIN_MONEY;  // 抽中了 0 ，转换为 0.01
                }
                money -= prize;
                count--;
                System.out.println(getName() + "抢到了" + prize + "元!");
            }
        }
    }
}
