package ManyThread.Test2;

import java.util.Random;

public class MyThread extends Thread {
    // ��������
    static double money = 100;  // ������
    static int count = 3;       // �������

    // ���ٽ��
    static final double MIN_MONEY = 0.01;

    @Override
    public void run() {
        synchronized (MyThread.class) {
            if (count == 0) {
                System.out.println(getName() + "û���������");
            } else {
                double prize;   // ������Ľ��
                if (count == 1) {
                    // ���������ʣ�µĶ����н����
                    prize = money;
                } else {
                    // ��һ�Ρ��ڶ����������������
                    Random random = new Random();
                    prize = random.nextDouble(money - (count - 1) * MIN_MONEY);
                    if(prize < MIN_MONEY)
                        prize = MIN_MONEY;  // ������ 0 ��ת��Ϊ 0.01
                }
                money -= prize;
                count--;
                System.out.println(getName() + "������" + prize + "Ԫ!");
            }
        }
    }
}
