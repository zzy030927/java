package ManyThread.Test3;

import java.util.ArrayList;
import java.util.Collections;

// �齱��齱
/*
    ��һ���齱�䣬�ó齱���д���˽����Ľ��ó齱��Ľ���Ϊ {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700}
    ���������齱��
    ����Ĵӳ齱���л�ȡ����Ԫ�ز���ӡ�ڿ���̨�ϣ���ʽ���£�
        ÿ�γ��һ������ʹ�ӡһ��
 */
public class ThreadDemo {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        // Collections�еľ�̬���� addAll �����в�����ӵ� list ��
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);

        MyThread myThread1 = new MyThread(list);
        MyThread myThread2 = new MyThread(list);
        MyThread myThread3 = new MyThread(list);
        MyThread myThread4 = new MyThread(list);
        MyThread myThread5 = new MyThread(list);

        myThread1.setName("�߳�1");
        myThread2.setName("�߳�2");
        myThread3.setName("�߳�2");
        myThread4.setName("�߳�4");
        myThread5.setName("�߳�5");

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
    }
}
