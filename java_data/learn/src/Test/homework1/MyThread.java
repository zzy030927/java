package Test.homework1;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    static int[] buffer = new int[]{0};
    static int[] WX = new int[100];
    static int i = 0;
    static int data;
    static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            if (Thread.currentThread().getName() == "PA") {
                lock.lock();
                if (buffer[0] == 0) {
                    Scanner scr = new Scanner(System.in);
                    data = scr.nextInt();
                    if (data == -1) {
                        System.out.println("�ѽ��ܵ���������: ");
                        for (int j = 0; j <= WX.length; j++) {
                            if(WX[j] == 0) break;
                            System.out.printf(WX[j] + " ");
                        }
                        System.exit(0);
                    }
                    buffer[0] = data;
                    System.out.println("�߳�PA�ѷ�������" + buffer[0]);
                } else {
                    System.out.println("�ȴ��߳�PB������");
                }
                lock.unlock();
            }
            else {
                lock.lock();
                if (buffer[0] != 0) {
                    System.out.println("�߳�PB����������" + buffer[0]);
                    WX[i++] = buffer[0];
                    buffer[0] = 0;
                } else {
                    System.out.println("�ȴ��߳�PA������");
                }
                lock.unlock();
            }
        }
    }
}
