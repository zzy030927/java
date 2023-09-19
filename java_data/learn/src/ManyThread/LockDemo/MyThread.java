package ManyThread.LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// ��������� synchronized ͬ���������ԣ�Lock ��������ṩ���ֶ��������ֶ��ͷ����ĺ���
// ��Ϊ Lock ��һ���ӿڣ���������Ҫ�̳� ʵ��Lock���ࣺ ReentrantLock��
public class MyThread extends Thread {

    static int ticket = 0;
    static Lock lock = new ReentrantLock(); // �����Ƕ��̣߳����ܻ��ж������ new MyThread()������Ҫ�� lock ����Ϊ��̬�ģ���ֹ�ж�������֡�

    @Override
    public void run() {
        while(true){
            lock.lock();    // ����
            if(ticket < 100){
                ticket++;
                System.out.println(getName() + "���ڵ���" + ticket + "��Ʊ!");
            }
            else {
                lock.unlock();  // ����ѭ����ͬʱ�ر�������
                break;
            }
            lock.unlock();  // �ͷ���
        }
    }
}
